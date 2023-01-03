import { AbstractEntity } from "./AbstractEntity"
import { Cor } from "./enum/Cor"
import { Modelo } from "./Modelo"
import { User } from "./User"

export class Caminhao extends AbstractEntity{

    placa!: string
    modelo!: Modelo
    motorista!: User
    ano!: number
    cor!: Cor
    observacao!: string
    
}