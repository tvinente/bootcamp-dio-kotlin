package dominio.Pedido

import dominio.Cartao.Cartao
import dominio.contratos.Impressora
import operadora.Operadora

class Pagamento(
    private val operadora: Operadora,
    private val impressora: Impressora
) {
    fun fechaPedido(pedido: Pedido, cartao: Cartao, senha: Int) {
        if (operadora.autortiza(cartao, senha, pedido.valorTotal())) {
            impressora.imprime(pedido)

        } else {
            println("Compra não autorizada")
        }

    }
}