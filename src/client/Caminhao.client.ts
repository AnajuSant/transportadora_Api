import { Caminhao } from '@/model/Caminhao'
import axios, { AxiosInstance } from 'axios'

export class CaminhaoClient {

    private axiosClient: AxiosInstance

    constructor(){
        this.axiosClient = axios.create({
            baseURL: 'http://localhost:8090/api/caminhoes',
            headers: {
                'Content-type': 'application/json'
            }
        })

    }

    public async findById(id: number) : Promise<Caminhao> {
        try{
            return (await this.axiosClient.get<Caminhao>(`/${id}`)).data
        }catch(error: any){
            return Promise.reject(error.response)
        }
    }

    public async findAll() : Promise<Caminhao[]> {
        try {
            return (await this.axiosClient.get<Caminhao[]>(``)).data
        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async create(caminhao: Caminhao) : Promise<void> {
        try {
            return (await this.axiosClient.post(``, caminhao)).data
        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async update(caminhao: Caminhao) : Promise<void> {
        try {
            return (await this.axiosClient.put(`/${caminhao.id}`, caminhao)).data
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