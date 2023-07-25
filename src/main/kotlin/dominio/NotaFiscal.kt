package dominio

import dominio.Pedido.Pedido
import dominio.contratos.Imprimivel

class NotaFiscal(private val pedido: Pedido) : Imprimivel {
    override fun obtemCabecalho(): String {
        return "Nota Fiscal Prefeitura de Belém"
    }

    override fun obtemCorpo(): String {
        return pedido.obtemCorpo()
    }

    override fun obtemRodape(): String {
        return "-----------------------"
    }
}