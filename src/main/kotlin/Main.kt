import dominio.Cartao.Bandeira
import dominio.Cartao.Cartao
import dominio.Cliente
import dominio.NotaFiscal
import dominio.Pedido.ItemPedido
import dominio.Pedido.Pagamento
import dominio.Pedido.Pedido
import dominio.ProdutoFactory
import impressao.Epson
import impressao.Hp
import operadora.Cielo
import operadora.Rede

fun main() {
    val arroz = ProdutoFactory.create(nome = "Arroz", preco = 25.0)
    val feijao = ProdutoFactory.create(nome = "Feijão", preco = 7.0)
    val leite = ProdutoFactory.create(nome = "Leite", preco = "4.0")
    val farinha = ProdutoFactory.create(nome = "Farinha", preco = 4)

    var joao = Cliente(nome = "João", cpf = "222.333.444-55")
    val pedido = Pedido(joao)

    val itemPedido_arroz = ItemPedido(arroz, 1)
    val itemPedido_feijao = ItemPedido(feijao, 2)

    pedido.adicionaProduto(itemPedido_arroz)
    pedido.adicionaProduto(itemPedido_feijao)

    val cartao = Cartao(nomeTitular = "João da Silva", numero = "12312345678910", bandeira = Bandeira.MASTERCARD)

    val operadora = Cielo()
    val impressora = Hp()
    val pagamento = Pagamento(operadora, impressora)


    pagamento.fechaPedido(pedido, cartao, senha = 1234)
    impressora.imprime(NotaFiscal(pedido))
}


