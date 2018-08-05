package sga.services.impl;

import sga.eis.dao.UsuarioDao;
import sga.eis.dto.Usuario;
import sga.eis.exceptions.UsuarioDaoException;
import sga.eis.factory.UsuarioDaoFactory;
import sga.services.UsuarioService;
import sga.services.exceptions.BusinessException;

/**
 *
 * @author Ubaldo
 */
public class UsuarioServiceImpl implements UsuarioService {

  //Utilizamos el patron singleton, solo existen un objeto de tipo UsuarioService en Memoria
  private static UsuarioService usuarioServiceInstance;

  //Creamos un atributo usuarioDao para comunicarnos con la capa de datos
  UsuarioDao usuarioDao;

  //Constructor sin argumentos privado, para implementar el patron singleton
  private UsuarioServiceImpl(){}

  //Creamos una nueva y unica instancia si es que no existe
  public static UsuarioService getInstance(){
    if(usuarioServiceInstance == null){
      usuarioServiceInstance = new UsuarioServiceImpl();
    }
    return usuarioServiceInstance;
  }


  public boolean usuarioExistente(Usuario usuarioDto){
    try {

      this.usuarioDao = UsuarioDaoFactory.create();

      //Buscamos el objeto por UserName y password
      final String SQL_WHERE = "username = ? and password = ?";

      Object[] sqlParams = {usuarioDto.getUsername(), usuarioDto.getPassword()};
      Usuario[] usuarios =this.usuarioDao.findByDynamicWhere(SQL_WHERE, sqlParams);

      if(usuarios.length > 0)
        return true;

    } catch (UsuarioDaoException ex) {
      throw new BusinessException("Existe un problema al obtener el usuario en la BD", ex);
    }

    //En cualquier otro caso, regresa falso
     return false;
	}

}
