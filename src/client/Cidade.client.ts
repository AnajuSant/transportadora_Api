import { Caminhao } from '@/model/Caminhao'
import { Cidade } from '@/model/Cidade'
import axios, { AxiosInstance } from 'axios'

export class CidadeClient {

    private axiosClient: AxiosInstance

    constructor(){
        this.axiosClient = axios.create({
            baseURL: 'http://localhost:8090/api/cidades',
            headers: {
                'Content-type': 'application/json'
            }
        })

    }

    public async findById(id: number) : Promise<Cidade> {
        try{
            return (await this.axiosClient.get<Cidade>(`/${id}`)).data
        }catch(error: any){
            return Promise.reject(error.response)
        }
    }

    public async findByState(id: number) : Promise<Cidade[]> {
        try{
            return (await this.axiosClient.get<Cidade[]>(`/estado/${id}`)).data
        }catch(error: any){
            return Promise.reject(error.response)
        }
    }

    public async findAll() : Promise<Cidade[]> {
        try {
            return (await this.axiosClient.get<Cidade[]>(``)).data
        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async create(cidade: Cidade) : Promise<void> {
        try {
            return (await this.axiosClient.post(``, cidade)).data
        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async update(cidade: Cidade) : Promise<void> {
        try {
            return (await this.axiosClient.put(`/${cidade.id}`, cidade)).data
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