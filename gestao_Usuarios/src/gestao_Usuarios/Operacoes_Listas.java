package gestao_Usuarios;

import java.util.ArrayList;
import java.util.List;

/**
* Classe de operações em listas de usuários.
*
* @author  Guilherme Braga
* @version 1.0
* @since   2023-03-02
*/
public class Operacoes_Listas {
	
	/**
	* Método que recebe uma lista de usuários e retorna apenas os usuários que recebem benefícios.
	* @param ListaUsuarios Lista de usuários
	* @return List<usuarios> Lista de usuários filtrada 
	*/
	public List<Usuarios> criaLista_UsuarioscomBeneficios(List<Usuarios> ListaUsuarios){
		
		// trabalha-se com cópia da lista passada
		List<Usuarios> ListaUsuariosFiltrada = new ArrayList<>(ListaUsuarios);
		
		// para cada usuário, remove gerentes!
		for (int i = 0; i < ListaUsuariosFiltrada.size(); i++) {
			if ("Gerente".equals(ListaUsuariosFiltrada.get(i).getClass().getSimpleName())) {
				ListaUsuariosFiltrada.remove(i); 
				i = 0; 
			}
		}
		
		// O resultado é uma lista sem nenhum gerente cadastrado
		return ListaUsuariosFiltrada; 
		
	}
	
	/**
	* Método que recebe uma lista de usuários e retorna apenas os usuários que são vendedores.
	* @param ListaUsuarios Lista de usuários
	* @return List<usuarios> Lista de usuários filtrada 
	*/
	public List<Usuarios> criaLista_UsuariosVendedores(List<Usuarios> ListaUsuarios){
		
		// trabalha-se com cópia da lista passada
		List<Usuarios> ListaUsuariosFiltrada = new ArrayList<>(ListaUsuarios);
		
		// para cada usuário, se é um gerente ou um secretario, remove usuário
		for (int i = 0; i < ListaUsuariosFiltrada.size(); i++) {
			if ("Gerente".equals(ListaUsuariosFiltrada.get(i).getClass().getSimpleName())) {
				ListaUsuariosFiltrada.remove(i); 
				i = 0; 
			}
			
			if ("Secretario".equals(ListaUsuariosFiltrada.get(i).getClass().getSimpleName())) {
				ListaUsuariosFiltrada.remove(i); 
				i = 0; 
			}
		}
		
		// O resultado é uma lista só com vendedores cadastrados
		return ListaUsuariosFiltrada; 
		
	}

}
