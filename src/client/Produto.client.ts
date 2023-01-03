import { Caminhao } from '@/model/Caminhao'
import { Cidade } from '@/model/Cidade'
import { Produto } from '@/model/Produto'
import { User } from '@/model/User'
import axios, { AxiosInstance } from 'axios'

export class ProdutoClient {

    private axiosClient: AxiosInstance

    constructor(){
        this.axiosClient = axios.create({
            baseURL: 'http://localhost:8090/api/produtos',
            headers: {
                'Content-type': 'application/json'
            }
        })

    }

    public async findById(id: number) : Promise<Produto> {
        try{
            return (await this.axiosClient.get<Produto>(`/${id}`)).data
        }catch(error: any){
            return Promise.reject(error.response)
        }
    }

    public async findAll() : Promise<Produto[]> {
        try {
            return (await this.axiosClient.get<Produto[]>(``)).data
        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async create(produto: Produto) : Promise<void> {
        try {
            return (await this.axiosClient.post(``, produto)).data
        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async update(produto: Produto) : Promise<void> {
        try {
            return (await this.axiosClient.put(`/${produto.id}`, produto)).data
        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async delete(id: number) : Promise<void> {
        try{
            return (await this.axiosClient.delete(`/${id}`)).data
        }catch(error: any){
            return Promise.reject(error.response)
        }
    }

}