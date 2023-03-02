package gestao_Usuarios;
import java.util.*;

/**
* Classe de operações para lista de usuários e vendas.
*
* @author  Guilherme Braga
* @version 1.0
* @since   2023-03-02
*/
public class Operacoes {
	
	
	/**
	* Pergunta 1
	* Método que recebe uma lista de funcionários, mês e ano e retorna o valor total pago (salário e benefício) a esses funcionários no mês.
	* @param ListaUsuarios Lista de usuários
	* @param ListaVendas Lista de vendas
	* @param mes_calculado Mês de interesse, em inteiro
	* @param ano_calculado Ano de interesse, em inteiro
	* @return double Valor total pago em benefícios aos funcionários 
	*/
	public double Pagamentos_total_do_mes(List<Usuarios> ListaUsuarios, List<Vendas> ListaVendas, int mes_calculado, int ano_calculado) {
		
		double total_pago = 0; 
		int anos_contrib = 0; 
		double salario_total = 0; 
		double bonus_total = 0; 
		
		// para cada funcionario...
		for (int i = 0; i < ListaUsuarios.size(); i++) {
			
			// se o funcionário era contratado naquele momento...
			if( (ListaUsuarios.get(i).get_AnoContratacao() <= ano_calculado) || ((ListaUsuarios.get(i).get_AnoContratacao() == ano_calculado) && (ListaUsuarios.get(i).get_MesContratacao() <= mes_calculado))) {
				
				// pega quantos anos o funcionário tem de contribuição
				anos_contrib = ListaUsuarios.get(i).get_AnosContribuicao(mes_calculado, ano_calculado); 
					
				// pagamento do funcionário = base + bonus * anos
				salario_total = ((anos_contrib * ListaUsuarios.get(i).get_Bonus_por_ano()) + ListaUsuarios.get(i).get_SalarioBase());
					
				// calculando bônus
					
				if ("Secretario".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
					// secretário recebe porcentagem de bonus multiplicado por salario
					bonus_total = ListaUsuarios.get(i).get_Beneficio() * salario_total; 
					
				}
					
				if ("Vendedor".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
						
					for (int j = 0; j < ListaVendas.size(); j++) {
							
						if((ListaVendas.get(j).get_AnoVenda() == ano_calculado)  && (ListaVendas.get(j).get_MesVenda() == mes_calculado)) {
								
							// vendedor recebe venda multiplicado por porcentagem de seu benefício
							bonus_total = (ListaUsuarios.get(i).get_Beneficio() * ListaVendas.get(j).get_Valor()); 
							
						}
							
					}
						
						
				}
					
				if ("Gerente".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
						
					// gerente não tem bonus
					bonus_total = 0; 
				}
					
				total_pago = total_pago + salario_total + bonus_total;  
				
				
			}
			
		}
		
		System.out.println("O total pago em salários + benefícios em " + mes_calculado + "/" + ano_calculado + " foi de " + total_pago + " reais.\n"); 
		
		return total_pago; 
		 
	}
	
	/**
	* Pergunta 2
	* Método que que recebe uma lista de funcionários, mês e ano e retorna o total pago somente em salários no mês.
	* @param ListaUsuarios Lista de usuários
	* @param mes_calculado Mês de interesse, em inteiro
	* @param ano_calculado Ano de interesse, em inteiro
	* @return double Total pago em salário em dado mês
	*/
	public double Pagamentos_salario_do_mes(List<Usuarios> ListaUsuarios, int mes_calculado, int ano_calculado) {
		
		int total_pago = 0; 
		int anos_contrib = 0; 
		
		// para cada funcionario...
		for (int i = 0; i < ListaUsuarios.size(); i++) {
			
			// se o funcionário era contratado naquele momento...
			if( (ListaUsuarios.get(i).get_AnoContratacao() < ano_calculado) || ((ListaUsuarios.get(i).get_AnoContratacao() == ano_calculado) && (ListaUsuarios.get(i).get_MesContratacao() <= mes_calculado))) {
				
				// pega quantos anos o funcionário tem de contribuição
				anos_contrib = ListaUsuarios.get(i).get_AnosContribuicao(mes_calculado, ano_calculado); 
					
				// pagamento do funcionário = base + bonus * anos 
				total_pago = total_pago + ((anos_contrib * ListaUsuarios.get(i).get_Bonus_por_ano()) + ListaUsuarios.get(i).get_SalarioBase()); 

				
				
			}
			
		}
		
		System.out.println("O total pago em salários em " + mes_calculado + "/" + ano_calculado + " foi de " + total_pago + " reais.\n"); 
		
		return total_pago; 
	}
	
	/**
	* Pergunta 3
	* Método que recebe uma lista somente com os funcionários que recebem benefícios, mês e ano e retorna o total pago em benefícios no mês.
	* @param ListaUsuarios Lista de usuários
	* @param ListaVendas Lista de vendas
	* @param mes_calculado Mês de interesse, em inteiro
	* @param ano_calculado Ano de interesse, em inteiro
	* @return double Valor total pago em benefícios
	*/
	public double Total_pago_beneficios(List<Usuarios> ListaUsuarios, List<Vendas> ListaVendas, int mes_calculado, int ano_calculado) {

		double beneficio_total_pago = 0; 
		int anos_contrib = 0; 
		double salario_total = 0; 
		double bonus_total = 0; 
		
		// para cada funcionario...
		for (int i = 0; i < ListaUsuarios.size(); i++) {
			
			// se o funcionário era contratado naquele momento...
			if( (ListaUsuarios.get(i).get_AnoContratacao() < ano_calculado) || ((ListaUsuarios.get(i).get_AnoContratacao() == ano_calculado) && (ListaUsuarios.get(i).get_MesContratacao() <= mes_calculado))) {
				
				// pega quantos anos o funcionário tem de contribuição
				anos_contrib = ListaUsuarios.get(i).get_AnosContribuicao(mes_calculado, ano_calculado); 
					
				// pagamento do funcionário = base + bonus * anos
				salario_total = ((anos_contrib * ListaUsuarios.get(i).get_Bonus_por_ano()) + ListaUsuarios.get(i).get_SalarioBase());
					
				// calculando bônus
					
				if ("Secretario".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
					// secretário recebe porcentagem de bonus multiplicado por salario
					bonus_total = ListaUsuarios.get(i).get_Beneficio() * salario_total; 
					
				}
					
				if ("Vendedor".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
						
					for (int j = 0; j < ListaVendas.size(); j++) {
							
						if((ListaVendas.get(j).get_AnoVenda() == ano_calculado)  && (ListaVendas.get(j).get_MesVenda() == mes_calculado)) {
								
							// vendedor recebe venda multiplicado por porcentagem de seu benefício
							bonus_total = (ListaUsuarios.get(i).get_Beneficio() * ListaVendas.get(j).get_Valor()); 
							
						}
							
					}
						
				}
					
				beneficio_total_pago = beneficio_total_pago + bonus_total; 
				
			}
		
		}
		
		System.out.println("O benefício total pago em " + mes_calculado + "/" + ano_calculado + " foi de " + beneficio_total_pago + " reais.\n"); 
		
		return beneficio_total_pago; 
	}
	
	
	/**
	* Pergunta 4
	* Método que receba uma lista de funcionários, mês e ano e retorne o que recebeu o valor mais alto no mês.
	* @param ListaUsuarios Lista de usuários
	* @param ListaVendas Lista de vendas
	* @param mes_calculado Mês de interesse, em inteiro
	* @param ano_calculado Ano de interesse, em inteiro
	* @return Usuarios Objeto de classe usuario que recebeu mais valor no mês
	*/
	public Usuarios Quem_recebeu_mais(List<Usuarios> ListaUsuarios, List<Vendas> ListaVendas, int mes_calculado, int ano_calculado) {

		// assumo que como não posso ver as vendas do cargo "Vendedor", se leva em conta quem teve o salário mais em dado mês/ano
		
		int salario_total = 0; 
		int anos_contrib = 0; 
		double maior_pagamento = 0; 
		double bonus_total = 0;
		double pago_usuario = 0;
		Usuarios Usuario_Maior_Pagamento = ListaUsuarios.get(0); 
		
		// para cada funcionario...
		for (int i = 0; i < ListaUsuarios.size(); i++) {
			
			// se o funcionário era contratado naquele momento...
			if( (ListaUsuarios.get(i).get_AnoContratacao() < ano_calculado) || ((ListaUsuarios.get(i).get_AnoContratacao() == ano_calculado) && (ListaUsuarios.get(i).get_MesContratacao() <= mes_calculado))) {
					
				// pega quantos anos o funcionário tem de contribuição
				anos_contrib = ListaUsuarios.get(i).get_AnosContribuicao(mes_calculado, ano_calculado); 
					
				// pagamento do funcionário = base + bonus * anos 
				salario_total = ((anos_contrib * ListaUsuarios.get(i).get_Bonus_por_ano()) + ListaUsuarios.get(i).get_SalarioBase()); 
					
				// se o que foi calculado pra esse mês é o maior valor daquele mês
				// ele passa a ser o maior pagamento
					
					
				if ("Secretario".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
					// secretário recebe porcentagem de bonus multiplicado por salario
					bonus_total = ListaUsuarios.get(i).get_Beneficio() * salario_total; 
					
				}
					
				if ("Vendedor".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
						
					for (int j = 0; j < ListaVendas.size(); j++) {
							
						if((ListaVendas.get(j).get_AnoVenda() == ano_calculado)  && (ListaVendas.get(j).get_MesVenda() == mes_calculado)) {
								
							// vendedor recebe venda multiplicado por porcentagem de seu benefício
							bonus_total = (ListaUsuarios.get(i).get_Beneficio() * ListaVendas.get(j).get_Valor()); 
							
						}
							
					}
						
				}
					
				if ("Gerente".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
						
					bonus_total = 0; 
						
				}
					
				pago_usuario = salario_total + bonus_total; 
					
				if (pago_usuario > maior_pagamento) {
							
					maior_pagamento = pago_usuario;
					Usuario_Maior_Pagamento = ListaUsuarios.get(i); 
							
				}
					
				
				
			}
			
		}
		
		if (maior_pagamento != 0) {
			
			System.out.println("Quem obteve o maior pagamento em " + mes_calculado + "/" + ano_calculado + " foi " + Usuario_Maior_Pagamento.get_Nome() + " com o valor de " + maior_pagamento + " reais.\n"); 
			
		}
		
		return Usuario_Maior_Pagamento; 
		
		
	}
	
	/**
	* Pergunta 5
	* Método que receba uma lista de funcionários, mês e ano e retorna o que recebeu o valor mais alto em benefícios no mês.
	* @param ListaUsuarios Lista de usuários
	* @param ListaVendas Lista de vendas
	* @param mes_calculado Mês de interesse, em inteiro
	* @param ano_calculado Ano de interesse, em inteiro
	* @return Usuario Objeto de classe usuario que recebeu maior bônus
	*/
	public Usuarios Quem_recebeu_mais_beneficio(List<Usuarios> ListaUsuarios, List<Vendas> ListaVendas, int mes_calculado, int ano_calculado) {
		
		double total_pago = 0; 
		int anos_contrib = 0; 
		double salario_total = 0; 
		double bonus_total = 0; 
		double maior_bonus = 0; 
		Usuarios Usuario_Maior_Bonus = ListaUsuarios.get(0);
		
		// para cada funcionario...
		for (int i = 0; i < ListaUsuarios.size(); i++) {
			
			// se o funcionário era contratado naquele momento...
			if( (ListaUsuarios.get(i).get_AnoContratacao() < ano_calculado) || ((ListaUsuarios.get(i).get_AnoContratacao() == ano_calculado) && (ListaUsuarios.get(i).get_MesContratacao() <= mes_calculado))) {
				
				// pega quantos anos o funcionário tem de contribuição
				anos_contrib = ListaUsuarios.get(i).get_AnosContribuicao(mes_calculado, ano_calculado); 
					
				// pagamento do funcionário = base + bonus * anos
				salario_total = ((anos_contrib * ListaUsuarios.get(i).get_Bonus_por_ano()) + ListaUsuarios.get(i).get_SalarioBase());
					
				// calculando bônus
					
				if ("Secretario".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
					// secretário recebe porcentagem de bonus multiplicado por salario
					bonus_total = ListaUsuarios.get(i).get_Beneficio() * salario_total; 
					
				}
					
				if ("Vendedor".equals(ListaUsuarios.get(i).getClass().getSimpleName())) {
						
					// se itera por todas as vendas...
					for (int j = 0; j < ListaVendas.size(); j++) {
							
						// se o nome do vendedor bate com o nome do resposnável pela venda
						// e se aquele registro de venda corresponde ao mês e ano desejado...
						if((ListaVendas.get(j).get_NomeResponsavel().equals(ListaUsuarios.get(i).get_Nome())) && (ListaVendas.get(j).get_AnoVenda() == ano_calculado) && (ListaVendas.get(j).get_MesVenda() == mes_calculado)) {
								
							// vendedor recebe venda multiplicado por porcentagem de seu benefício
							bonus_total = (ListaUsuarios.get(i).get_Beneficio() * ListaVendas.get(j).get_Valor()); 
							
						}
							
					}
							
				}
					
				// esse bonus é o maior calculado historicamente?
				if (bonus_total >= maior_bonus) {
						
					maior_bonus = bonus_total; 
					Usuario_Maior_Bonus = ListaUsuarios.get(i); 
						
				}
					
					
			}
			
		}
		
		if (maior_bonus != 0){
			
			System.out.println("Quem obteve o maior benefício em " + mes_calculado + "/" + ano_calculado + " foi " + Usuario_Maior_Bonus.get_Nome() + " com o valor de " + maior_bonus + " reais.\n");
			
		}
			
		return Usuario_Maior_Bonus; 
		
	}
	
	/**
	* Pergunta 6
	* Método que receba uma lista de vendedores, mês e ano e retorne o que mais vendeu no mês.
	* @param ListaUsuarios Lista de usuários
	* @param ListaVendas Lista de vendas
	* @param mes_calculado Mês de interesse, em inteiro
	* @param ano_calculado Ano de interesse, em inteiro
	* @return Vendedor Vendedor que vendeu mais no dado mês
	*/
	public Usuarios Vendedor_que_vendeu_mais(List<Usuarios> ListaUsuarios, List<Vendas> ListaVendas, int mes_calculado, int ano_calculado) {
		// "Um método que receba uma lista de vendedores, mês e ano e retorne o que mais vendeu no mês."
		
		double venda_total = 0; 
		double maior_venda = 0; 
		Usuarios Vendedor_Maior_Venda = ListaUsuarios.get(0);
		
		// para cada funcionario...
		for (int i = 0; i < ListaUsuarios.size(); i++) {
			
			// se o funcionário era contratado naquele momento...
			if( (ListaUsuarios.get(i).get_AnoContratacao() < ano_calculado) || ((ListaUsuarios.get(i).get_AnoContratacao() == ano_calculado) && (ListaUsuarios.get(i).get_MesContratacao() <= mes_calculado))) {
					
				// se itera por todas as vendas...
				for (int j = 0; j < ListaVendas.size(); j++) {
						
					// se o nome do vendedor bate com o nome do resposnável pela venda
					// e se aquele registro de venda corresponde ao mês e ano desejado...
					if((ListaVendas.get(j).get_NomeResponsavel().equals(ListaUsuarios.get(i).get_Nome())) && (ListaVendas.get(j).get_AnoVenda() == ano_calculado) && (ListaVendas.get(j).get_MesVenda() == mes_calculado)) {
						// vendedor recebe venda multiplicado por porcentagem de seu benefício
						venda_total = ListaVendas.get(j).get_Valor(); 
					}
					
				}
					
				// essa é a maior venda?
				if (venda_total >= maior_venda) {
						
					maior_venda = venda_total; 
					Vendedor_Maior_Venda = ListaUsuarios.get(i); 
						
				}
					
				
			}		
		}
		
		if (maior_venda != 0){
			
			System.out.println("Quem vendeu mais em " + mes_calculado + "/" + ano_calculado + " foi " + Vendedor_Maior_Venda.get_Nome() + " com o valor de " + maior_venda + " reais.\n");
			
		}
		else {
			System.out.println("Não existia cadastro de vendedor/cadastro de vendas em " + mes_calculado + "/" + ano_calculado + "\n"); 
		}
		
		return Vendedor_Maior_Venda; 
	}
	
}
