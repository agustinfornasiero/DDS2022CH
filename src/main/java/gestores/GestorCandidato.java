/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;


import com.mycompany.consultorach.entidades.Candidato;
import com.mycompany.consultorach.entidades.Cuestionario;

import daos.CandidatoPGDao;
import daos.CuestionarioPGDao;



import dtos.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Zapa
 */
public class GestorCandidato {
    private static GestorCandidato instancia;

   
    private GestorCandidato(){
    }
    
    public synchronized static GestorCandidato getInstance(){
        if(instancia == null)
            instancia = new GestorCandidato();
        return instancia;
    }
    
     public UsuarioDTO autenticarCandidato(UsuarioDTO user){
        
        if(validarDatos(user) == true){
            CandidatoPGDao candidatoPG = new CandidatoPGDao();
            Candidato c = candidatoPG.buscarCandidato(user.getDocumento(), user.getTipoDocumento());
            
          
        
            GestorCuestionario gestorCuestionario = new GestorCuestionario();
            Cuestionario cuestionario = new Cuestionario();
            cuestionario = gestorCuestionario.existeCuestionario(user.getClave(),c.getId());
            
            if(cuestionario==null){
                System.out.println("EL CUESTIONARIO ES NULL");
                return new UsuarioDTO();
            }
            else{
                 if(c.getId()==cuestionario.getCandidato().getId()){
            UsuarioDTO candidatoDto = new UsuarioDTO();
            candidatoDto.setNumeroCandidato(c.getNumeroCandidato());
            candidatoDto.setDocumento(c.getDocumento());
            candidatoDto.setNombre(c.getNombre());
            candidatoDto.setApellido(c.getApellido());
            candidatoDto.setClave(user.getClave());
            candidatoDto.setCuestionario(cuestionario);
                
                
                candidatoDto.setCuestionario(cuestionario);
                return candidatoDto;
            }else{
                  return new UsuarioDTO();
            }
            }
           
         
            
        
       }
       else 
            return new UsuarioDTO();
        
    }

    public boolean validarDatos(UsuarioDTO user) {
       
        CandidatoPGDao dao = new CandidatoPGDao();
        
       List<String> listaDoc = new ArrayList();
         System.out.println("El dni es: "+user.getDocumento());
     listaDoc = dao.getDocumentoAll();
      //listaDoc.add(candidatoPG.getDocumentoAll());
  //candidatoPG.getDocumentoAll().forEach(System.out::println);
       return listaDoc.contains(user.getDocumento());
      // return listaDoc;
    }
    
    public boolean chequearCamposVacios(String numero, String clave){
        if(numero.isEmpty()==true || clave.isEmpty()==true){
            return false;
        }else
           return true;
    }
    
    public List<UsuarioDTO> buscarCandidatoSegunCriterio(UsuarioDTO user){
       CandidatoPGDao candidatoPG = new CandidatoPGDao();
       List<Candidato> candidatos = candidatoPG.buscarCandidatoSegunCriterio(user);
       List<UsuarioDTO> usuarios = new ArrayList();
       
       for(int i=0; i<candidatos.size(); i++){
       UsuarioDTO candidato = new UsuarioDTO();
       candidato.setNumeroCandidato(candidatos.get(i).getNumeroCandidato());
       candidato.setApellido(candidatos.get(i).getApellido());
       candidato.setNombre(candidatos.get(i).getNombre());
       candidato.setTipoDocumento(candidatos.get(i).getTipoDocumento());
       candidato.setDocumento(candidatos.get(i).getDocumento());
       
       usuarios.add(candidato);
       }
       return usuarios;
   }
    
    
   public List<UsuarioDTO> comprobarCandidatos(List<UsuarioDTO> candidatos){
       
      List<UsuarioDTO> noPasan =new ArrayList();
      List<UsuarioDTO> pasan =new ArrayList();
      CuestionarioPGDao cuestionarioPG = new CuestionarioPGDao(); 
      CandidatoPGDao candidatoPG = new CandidatoPGDao();
      List<Cuestionario> c = new ArrayList();
      UsuarioDTO vacio = new UsuarioDTO();
       for(int i=0; i< candidatos.size(); i++){ 
           
           Candidato candidato = new Candidato();
           candidato = candidatoPG.buscarCandidato(candidatos.get(i).getDocumento(), candidatos.get(i).getTipoDocumento());
           c = cuestionarioPG.getCuestionarioByidCandidato(candidato.getId());
         
           if(c.isEmpty()){
               pasan.add(candidatos.get(i));
           }else{
                if(c.get(0).getEstado().equals("ACTIVO") || c.get(0).getEstado().equals("EN_PROCESO"))
                    noPasan.add(candidatos.get(i));
                else
                     pasan.add(candidatos.get(i));
                 }
            }
    
       if(noPasan.isEmpty()==false){
           //noPasan.add(vacio);
            return noPasan;
       }
           
       else{
           // ESTO ES SI DE LOS CANDIDATOS SELECCIONADOS, NINGUNO TIENE CUESTIONARIO ACTIVO, LES GENERO UNA CLAVE PARA EL MISMO
           /*if(candidatos.size()== pasan.size()){
               for(int i=0; i<pasan.size(); i++){
       UsuarioDTO candidatoDTO = new UsuarioDTO();
       candidatoDTO.setApellido(pasan.get(i).getApellido());
       candidatoDTO.setNombre(pasan.get(i).getNombre());
       candidatoDTO.setTipoDocumento(pasan.get(i).getTipoDocumento());
       candidatoDTO.setDocumento(pasan.get(i).getDocumento());
       
       listaCandidatosDTO.add(candidatoDTO);
       }
           }*/
           if(pasan.size() == candidatos.size()) generarClave(pasan);
           return pasan;
       }
       
       
            
       //return listaCandidatosDTO;
   }
   
 
   public void generarClave(List<UsuarioDTO> candidatosDTO){
       
       int min = 1;
       int max = 10000000;
    Random rn = new Random();
    int range = max - min + 1;
    for(int i=0; i<candidatosDTO.size(); i++){
        int randomNum =  rn.nextInt(range) + min;
        String random = Integer.toString(randomNum);
        candidatosDTO.get(i).setClave(random);
    }
   }
 List<Candidato> buscarCandidatos(List<UsuarioDTO> usuariosDTO) {
         List<Candidato> lista = new ArrayList();
         CandidatoPGDao dao = new CandidatoPGDao();
         Candidato c = new Candidato();
         for(int i=0; i<usuariosDTO.size(); i++){
             c=dao.buscarCandidato(usuariosDTO.get(i).getDocumento(), usuariosDTO.get(i).getTipoDocumento());
             lista.add(c);
             
         }
         return lista;
    }
}

