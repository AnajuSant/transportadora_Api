import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import CadastroFrete from '@/views/Frete/Cadastro.vue'
import ListagemFrete from '@/views/Frete/Listagem.vue'
import StatusTransporte from '@/views/Frete/StatusTransporte.vue'
import StatusInterrompido from '@/views/Frete/StatusInterrompido.vue'
import StatusCancelado from '@/views/Frete/StatusCancelado.vue'
import StatusDescarga from '@/views/Frete/StatusDescarga.vue'


const routes: Array<RouteRecordRaw> = [
  {
    path: '/cadastro',
    name: 'Cadastro de Frete',
    component: CadastroFrete
  },
  {
    path: '/listagem',
    name: 'Listagem dos fretes',
    component: ListagemFrete
  },
  {
    path: '/statusTransporte/:id',
    name: 'Status Transporte',
    component: StatusTransporte
  },
  {
    path: '/statusInterrompido/:id',
    name: 'Status Interrompido',
    component: StatusInterrompido
  },
  {
    path: '/statusCancelado/:id',
    name: 'Status Cancelado',
    component: StatusCancelado
  },
  {
    path: '/statusDescarga/:id',
    name: 'Status Descarga',
    component: StatusDescarga
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
