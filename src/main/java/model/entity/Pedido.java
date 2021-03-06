/**
 * 
 */
package model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Mikaelbr073
 *
 */
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

	private static final long serialVersionUID = -3060421892280179341L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PEDIDO")
	private Long id;

	@Column(name = "VALOR_TOTAL", columnDefinition = "DOUBLE PRECISION", nullable = false)
	private double valorTotal;

	@Column(name = "DATA", nullable = false)
	private LocalDate data;
	@Embedded
	private Endereco endereco;

	@JoinColumn(name = "PEDIDO_ID_CLIENTE", referencedColumnName = "ID_CLIENTE", columnDefinition = "INTEGER")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Cliente cliente;

	@OneToOne(cascade = CascadeType.ALL)
	private PedidoProduto pedidoProduto;

	@OneToMany
	@ElementCollection
	private List<Produto> produtos = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(Long id, double valorTotal, LocalDate data, Endereco endereco, Cliente cliente) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.data = data;
		this.endereco = endereco;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PedidoProduto getPedidoProduto() {
		return pedidoProduto;
	}

	public void setPedidoProduto(PedidoProduto pedidoProduto) {
		this.pedidoProduto = pedidoProduto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	};

	public void adicionaProdutoLista(Produto produto) {
		this.produtos.add(produto);
	}

}
