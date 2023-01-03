import { AbstractEntity } from "./AbstractEntity"
import { Grupo } from "./enum/Grupo"

export class User extends AbstractEntity{

    login!: string
    senha!: string
    nome!: string
    cpf!: string
    telefone!: string
    endereco!: string
    dataNascimento!: Date
    grupo!: Grupo
    perGanho!: number
    observacao!: string
    
}