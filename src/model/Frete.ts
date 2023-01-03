import { AbstractEntity } from "./AbstractEntity"
import { Caminhao } from "./Caminhao"
import { Cidade } from "./Cidade"
import { StatusFrete } from "./enum/StatusFrete"
import { Estado } from "./Estado"
import { Produto } from "./Produto"
import { User } from "./User"

export class Frete extends AbstractEntity{

    produto!: Produto
    cidadeOrigem!: Cidade
    cidadeDestino!: Cidade
    motorista!: User
    caminhao!: Caminhao
    statusFrete!: StatusFrete
    quilometragemIni!: number
    quilometragemFim!: number
    totalBrutoRecebidoNota!: number
    totalLiquidoRecebido!: number
    pesoInicial!: number
    pesoFinal!: number
    precoTonelada!: number
    observacao!: string
    
}