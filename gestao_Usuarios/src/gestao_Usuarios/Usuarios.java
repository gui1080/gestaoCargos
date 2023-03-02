package gestao_Usuarios;

import java.time.*;
import java.util.*;

/**
* Classe de usuarios serve como base para classes: secretario, vendedor e gerente.
* Todo usuário tem seu salário base, valor de bonus, uma porcentagem de seu benefício e data de contratação.
*
* @author  Guilherme Braga
* @version 1.0
* @since   2023-03-02
*/
public class Usuarios {
	
	private int salario_base; 
	private int bonus_por_ano; 
	private double beneficio;
	LocalDate data_contratacao = LocalDate.now();
	
	private String nome; 
	
	/**
	* Método construtor padrão da classe usuário, a ser usado por classes que extendem usuarios.
	* @param mes_contratacao Mês da contratação do usuário, em inteiro
	* @param ano_contratacao Ano da contratação do usuário, em inteiro
	* @param nome  String de nome do usuario
	*/
	public Usuarios(int mes_contratacao, int ano_contratacao, String nome) {
		
		LocalDate contratacao_correta = LocalDate.of(ano_contratacao, mes_contratacao, 01);
		this.data_contratacao = contratacao_correta; 
		
		this.nome = nome; 
	}
	
	/**
	* Método que define o benefício da classe usuario.
	* @param beneficio Valor do benefício (porcentagem), em double
	*/
	public void set_Beneficio(double beneficio) {
		this.beneficio = beneficio;
	}
	
	/**
	* Método que define o valor do bônus anual da classe usuario.
	* @param beneficio Valor do bônus (inteiro, "reais"), em int
	*/
	public void set_Bonus_por_ano(int bonus_por_ano) {
		this.bonus_por_ano = bonus_por_ano;
	}
	
	/**
	* Método que define o valor do salário da classe usuario.
	* @param beneficio Valor do salário (inteiro, "reais"), em int
	*/
	public void set_SalarioBase(int salario_base) {
		this.salario_base = salario_base;
	}
	
	/**
	* Método que retorna o nome do objeto da classe usuario.
	* @return String Nome do usuario
	*/
	public String get_Nome() {
		return this.nome; 
	}
	
	/**
	* Método que retorna o ano da contratação do objeto da classe usuario.
	* @return int Ano da contratação do usuario
	*/
	public int get_AnoContratacao() {
		return this.data_contratacao.getYear();
	}
	
	/**
	* Método que retorna o benefício (porcentagem) do objeto da classe usuario.
	* @return double Benefício (porcentagem) do usuario
	*/
	public double get_Beneficio() {
		return this.beneficio; 
	}
	
	/**
	* Método que retorna o mês da contratação do objeto da classe usuario.
	* @return int Mês da contratação do usuario
	*/
	public int get_MesContratacao() { 
		return this.data_contratacao.getMonthValue();
	}
	
	/**
	* Método que retorna o salário base do objeto da classe usuario.
	* @return int Salário (reais) base do usuario
	*/
	public int get_SalarioBase() {
		return this.salario_base; 
	}
	
	/**
	* Método que retorna o bônus anual do objeto da classe usuario.
	* @return int Bônus (reais) do usuario
	*/
	public int get_Bonus_por_ano() {
		return this.bonus_por_ano; 
	}
	
	/**
	* Método que define meses totais de contribuição de um dado usuario.
	* @param mes_atual Mês de interesse, em inteiro
	* @param ano_atual Ano de interesse, em inteiro
	* @return int Meses de contribuição do usuario até uma dada data
	*/
	public int get_MesesContribuicao(int mes_atual, int ano_atual) {
		
		LocalDate hoje = LocalDate.of(ano_atual, mes_atual, 01);
		
		Period diff = Period.between(this.data_contratacao, hoje);
		int meses_total = diff.getYears() * 12 + diff.getMonths(); 
		
		return meses_total; 
		
	}
	
	/**
	* Método que define anos completos de contribuição de um dado usuario.
	* @param mes_atual Mês de interesse, em inteiro
	* @param ano_atual Ano de interesse, em inteiro
	* @return int Anos completos de contribuição do usuario até uma dada data
	*/
	public int get_AnosContribuicao(int mes_atual, int ano_atual) {
		
		LocalDate hoje = LocalDate.of(ano_atual, mes_atual, 01);
		
		Period diff = Period.between(this.data_contratacao, hoje);
		int anos_total = diff.getYears();  
		
		return anos_total; 
		
	}
	
}

/**
* Classe de secretario, se extende de usuario.
* Um secretario tem 20% de benefício sobre o salário total.
* Seu salário base é de R$7000 com bônus de R$1000 por ano.
*
* @author  Guilherme Braga
* @version 1.0
* @since   2023-03-02
*/
class Secretario extends Usuarios{
	
	/**
	* Método construtor padrão da classe secretario.
	* @param mes_contratacao Mês da contratação do usuário, em inteiro
	* @param ano_contratacao Ano da contratação do usuário, em inteiro
	* @param nome  String de nome do usuario
	*/
	public Secretario(int mes_contratacao, int ano_contratacao, String nome) {
		super(mes_contratacao, ano_contratacao, nome); 
		set_Beneficio(0.2); 
		set_Bonus_por_ano(1000); 
		set_SalarioBase(7000); 
	}
	
}

/**
* Classe de vendedor, se extende de usuario.
* Um secretario tem 30% de benefício diante de suas vendas do mês.
* Seu salário base é de R$12000 com bônus de R$1800 por ano.
*
* @author  Guilherme Braga
* @version 1.0
* @since   2023-03-02
*/
class Vendedor extends Usuarios{
	
	/**
	* Método construtor padrão da classe vendedor.
	* @param mes_contratacao Mês da contratação do usuário, em inteiro
	* @param ano_contratacao Ano da contratação do usuário, em inteiro
	* @param nome  String de nome do usuario
	*/
	public Vendedor(int mes_contratacao, int ano_contratacao, String nome) {
		super(mes_contratacao, ano_contratacao, nome); 
		set_Beneficio(0.3); 
		set_Bonus_por_ano(1800); 
		set_SalarioBase(12000); 
	}
	
}

/**
* Classe de gerente, se extende de usuario.
* Um gerente não tem benefícios.
* Seu salário base é de R$20000 com bônus de R$3000 por ano.
*
* @author  Guilherme Braga
* @version 1.0
* @since   2023-03-02
*/
class Gerente extends Usuarios{
	
	/**
	* Método construtor padrão da classe gerente.
	* @param mes_contratacao Mês da contratação do usuário, em inteiro
	* @param ano_contratacao Ano da contratação do usuário, em inteiro
	* @param nome  String de nome do usuario
	*/
	public Gerente(int mes_contratacao, int ano_contratacao, String nome) {
		super(mes_contratacao, ano_contratacao, nome); 
		set_Beneficio(0.0); 
		set_Bonus_por_ano(3000); 
		set_SalarioBase(20000); 
	}
}