import { AbstractEntity } from "./AbstractEntity"
import { Frete } from "./Frete"
import { TipoDespesa } from "./TipoDespesa"
import { User } from "./User"

export class Caminhao extends AbstractEntity{

    tipoDespesa!: TipoDespesa
    valor!: number
    motorista!: User
    data!: Date
    aprovador!: User
    frete!: Frete
    
}