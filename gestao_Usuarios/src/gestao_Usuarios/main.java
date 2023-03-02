package gestao_Usuarios;
import java.util.*;

/**
* Classe main.
*
* @author  Guilherme Braga
* @version 1.0
* @since   2023-03-02
*/
public class main {
	
	/**
	* Método main padrão, usado para testes.
	* @param Args[] Argumentos da main
	*/
	public static void main(String Args[]){
		
		// declarando pessoas
		Secretario JorgeCarvalho = new Secretario(1, 2018, "Jorge Carvalho");
		Secretario MariaSouza = new Secretario(12, 2015, "Maria Souza");
		Vendedor AnaSilva = new Vendedor(12, 2021, "Ana Silva");
		Vendedor JoaoMendes = new Vendedor(12, 2021, "João Mendes");
		Gerente JulianaAlves = new Gerente(7, 2017, "Juliana Alves"); 
		Gerente BentoAlbino = new Gerente(3, 2014, "Bento Albino"); 
		
		// declarando vendas da ana
		Vendas Ana_dez2021 = new Vendas(12, 2021, 5200, AnaSilva);
		Vendas Ana_jan2022 = new Vendas(1, 2022, 4000, AnaSilva);
		Vendas Ana_fev2022 = new Vendas(2, 2022, 4200, AnaSilva);
		Vendas Ana_mar2022 = new Vendas(3, 2022, 5850, AnaSilva);
		Vendas Ana_abr2022 = new Vendas(4, 2022, 7000, AnaSilva);
		
		// declarando vendas do João
		Vendas Joao_dez2021 = new Vendas(12, 2021, 3400, JoaoMendes);
		Vendas Joao_jan2022 = new Vendas(1, 2022, 7700, JoaoMendes);
		Vendas Joao_fev2022 = new Vendas(2, 2022, 5000, JoaoMendes);
		Vendas Joao_mar2022 = new Vendas(3, 2022, 5900, JoaoMendes);
		Vendas Joao_abr2022 = new Vendas(4, 2022, 6500, JoaoMendes);
		
		// para o trabalho, se soliciou uma lista de todas as vendas
		List<Vendas> ListaVendas = new ArrayList<>();
		
		// se aloca as vendas da Ana
		ListaVendas.add(Ana_dez2021); 
		ListaVendas.add(Ana_jan2022); 
		ListaVendas.add(Ana_fev2022); 
		ListaVendas.add(Ana_mar2022); 
		ListaVendas.add(Ana_abr2022); 
		
		// se aloca as vendas do João
		ListaVendas.add(Joao_dez2021); 
		ListaVendas.add(Joao_jan2022); 
		ListaVendas.add(Joao_fev2022); 
		ListaVendas.add(Joao_mar2022); 
		ListaVendas.add(Joao_abr2022); 
		
		// para o trabalho, se solicita uma lista de todos os funcionários
		List<Usuarios> ListaUsuarios = new ArrayList<>();
		
		ListaUsuarios.add(JorgeCarvalho);
		ListaUsuarios.add(MariaSouza);
		ListaUsuarios.add(AnaSilva);
		ListaUsuarios.add(JoaoMendes);
		ListaUsuarios.add(JulianaAlves);
		ListaUsuarios.add(BentoAlbino);
		
		// ----------------------------------------------------------------
		
		System.out.println("\n---------------\n Iniciando testes \n---------------\n");
		
		// Operações com Listas!
		
		Operacoes_Listas op_listas = new Operacoes_Listas(); 
		
		// Lista de usuários que apresentam cargos sem benefícios como requisito para 
		List<Usuarios> ListaUsuariosBeneficiados = op_listas.criaLista_UsuarioscomBeneficios(ListaUsuarios); 
		
		// Lista de usuários que são vendedores
		List<Usuarios> ListaUsuariosVendedores = op_listas.criaLista_UsuariosVendedores(ListaUsuarios); 
		
		// Perguntas 3 e 5
		System.out.println("Lista de usuários com benefícios!\n");
		System.out.println(ListaUsuariosBeneficiados); 
		
		// para Pergunta 6
		System.out.println("Lista de vendedores!\n");
		System.out.println(ListaUsuariosVendedores); 
		
		// ----------------------------------------------------------------
		
		// Operações para manipulação de dados de cargos!
		
		operacoes op = new operacoes(); 
		
		// Pergunta 1
		System.out.println("\n---------------\n Pergunta 1 \n---------------\n");
		System.out.println(op.pagamentos_total_do_mes(ListaUsuarios, ListaVendas, 12, 2021)); 
		System.out.println(op.pagamentos_total_do_mes(ListaUsuarios, ListaVendas, 3, 2014)); 
		System.out.println(op.pagamentos_total_do_mes(ListaUsuarios, ListaVendas, 4, 2022));
		System.out.println(op.pagamentos_total_do_mes(ListaUsuarios, ListaVendas, 4, 1998));
				
		// Pergunta 2
		System.out.println("\n---------------\n Pergunta 2 \n---------------\n");
		System.out.println(op.pagamentos_salario_do_mes(ListaUsuarios, 12, 2021)); 
		System.out.println(op.pagamentos_salario_do_mes(ListaUsuarios, 3, 2014)); 
		System.out.println(op.pagamentos_salario_do_mes(ListaUsuarios, 3, 2015));
		System.out.println(op.pagamentos_salario_do_mes(ListaUsuarios, 3, 1997));
		
		// Pergunta 3
		System.out.println("\n---------------\n Pergunta 3 \n---------------\n");
		System.out.println(op.total_pago_beneficios(ListaUsuariosBeneficiados, ListaVendas, 12, 2021)); 
		System.out.println(op.total_pago_beneficios(ListaUsuariosBeneficiados, ListaVendas, 12, 2014)); 
		System.out.println(op.total_pago_beneficios(ListaUsuariosBeneficiados, ListaVendas, 4, 2022));
		System.out.println(op.total_pago_beneficios(ListaUsuariosBeneficiados, ListaVendas, 4, 1973));
		
		// Pergunta 4
		System.out.println("\n---------------\n Pergunta 4 \n---------------\n");
		System.out.println(op.quem_recebeu_mais(ListaUsuarios, ListaVendas, 12, 2021));
		System.out.println(op.quem_recebeu_mais(ListaUsuarios, ListaVendas, 3, 2014));
		System.out.println(op.quem_recebeu_mais(ListaUsuarios, ListaVendas, 1, 2017));
		System.out.println(op.quem_recebeu_mais(ListaUsuarios, ListaVendas, 1, 1967));
		
		// Pergunta 5
		System.out.println("\n---------------\n Pergunta 5 \n---------------\n");
		System.out.println(op.quem_recebeu_mais_beneficio(ListaUsuariosBeneficiados, ListaVendas, 12, 2021));
		System.out.println(op.quem_recebeu_mais_beneficio(ListaUsuariosBeneficiados, ListaVendas, 12, 2016));
		System.out.println(op.quem_recebeu_mais_beneficio(ListaUsuariosBeneficiados, ListaVendas, 1, 2022));
		
		// Pergunta 6
		System.out.println("\n---------------\n Pergunta 6 \n---------------\n");
		System.out.println(op.vendedor_que_vendeu_mais(ListaUsuariosVendedores, ListaVendas, 12, 2021)); 
		System.out.println(op.vendedor_que_vendeu_mais(ListaUsuariosVendedores, ListaVendas, 12, 2015)); 
		System.out.println(op.vendedor_que_vendeu_mais(ListaUsuariosVendedores, ListaVendas, 01, 2022)); 
		System.out.println(op.vendedor_que_vendeu_mais(ListaUsuariosVendedores, ListaVendas, 01, 2077)); 
		
	}
}
