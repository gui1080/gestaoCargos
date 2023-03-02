package gestao_Usuarios;

import java.time.LocalDate;

/**
* Classe de vendas, para registro de valor de venda por mês.
* Todo registro de venda tem seu valor, vendedor responsável, e data de venda.
*
* @author  Guilherme Braga
* @version 1.0
* @since   2023-03-02
*/
public class Vendas {
	
	private double valor; 
	private Vendedor responsavel; 
	LocalDate data_venda = LocalDate.now();
	
	/**
	* Método construtor padrão da classe usuário, a ser usado por classes que extendem usuarios.
	* @param mes_contratacao Mês da venda, em inteiro
	* @param ano_contratacao Ano da venda, em inteiro
	* @param valor Valor da venda, em double
	* @param vendedor Objeto de vendedor responsável pela venda
	*/
	public Vendas(int mes_venda, int ano_venda, double valor, Vendedor responsavel) {
		
		LocalDate venda_correta = LocalDate.of(ano_venda, mes_venda, 01);
		
		this.data_venda = venda_correta; 
		
		this.valor = valor; 
		this.responsavel = responsavel; 
	}
	
	/**
	* Método que retorna o valor da venda.
	* @return double Valor da venda
	*/
	public double get_Valor() {
		return this.valor; 
	}
	
	/**
	* Método que retorna o mês que a venda ocorreu.
	* @return int Mês da venda
	*/
	public int get_MesVenda() {
		return this.data_venda.getMonthValue();
	}
	
	/**
	* Método que retorna o ano que a venda ocorreu.
	* @return int Ano da venda
	*/
	public int get_AnoVenda() {
		return this.data_venda.getYear();
	}
	
	/**
	* Método que retorna o objeto de vendedor que fez a venda.
	* @return vendedor Vendedor responsável pela venda
	*/
	public Vendedor get_Responsavel() {
		return this.responsavel; 
	}
	
	/**
	* Método que retorna o nome do vendedor que fez a venda.
	* @return String Nome do vendedor responsável pela venda
	*/
	public String get_NomeResponsavel() {
		return this.responsavel.get_Nome();
	}
	
}
