<template>
  <div class="center">
    <table>
      <tr>
        <th>Status</th>
        <th>Cidade Origem</th>
        <th>Cidade Destino</th>
        <th>Produto</th>
        <th>Caminhao</th>
        <th>Motorista</th>
        <th>Preço por tonelada</th>
        <th>Ação</th>
      </tr>
      <tr v-for="(frete, index) in freteList" :key="index">
        <th>{{ frete.statusFrete }}</th>
        <th>{{ frete.cidadeOrigem.nome }}</th>
        <th>{{ frete.cidadeDestino.nome }}</th>
        <th>{{ frete.produto.nome }}</th>
        <th>{{ frete.caminhao.placa }}</th>
        <th>{{ frete.motorista.nome }}</th>
        <th>{{ frete.precoTonelada }}</th>
        <th>
          <div v-if="frete.statusFrete === 'CARGA'">
            <a v-bind:href="`/statusTransporte/${frete.id}`">
              <button>T</button>
            </a>
            <a v-bind:href="`/statusInterrompido/${frete.id}`">
              <button>I</button>
            </a>
            <a v-bind:href="`/statusCancelado/${frete.id}`">
              <button>C</button>
            </a>
          </div>

          <div v-if="frete.statusFrete === 'EM_TRANSPORTE'">
            <a v-bind:href="`/statusInterrompido/${frete.id}`">
              <button>I</button>
            </a>
            <a v-bind:href="`/statusDescarga/${frete.id}`">
              <button>D</button>
            </a>
          </div>

          <div v-if="frete.statusFrete === 'INTERROMPIDO'">
            <a v-bind:href="`/statusInterrompido/${frete.id}`">
              <button>I</button>
            </a>
            <a v-bind:href="`/statusDescarga/${frete.id}`">
              <button>D</button>
            </a>
          </div>

          <div v-if="frete.statusFrete === 'DESCARGA'">
            <a @click="statusFaturado($event)" :value="frete.id">
              <button>F</button>
            </a>
          </div>

        </th>
      </tr>
    </table>
  </div>
</template>

<script lang="ts">
import { Frete } from "@/model/Frete";
import { FreteClient } from "@/client/Frete.client";
import { Vue } from "vue-class-component";

export default class FreteList extends Vue {
  private freteClient: FreteClient = new FreteClient();
  public freteList: Frete[] = [];

  public mounted(): void {
    this.listarFretes();
  }

  private listarFretes(): void {
    this.freteClient.findAll().then(
      (success) => {
        console.log(success);
        this.freteList = success;
      },
      (error) => {
        console.log(error.data);
      }
    );
  }

  public async editStatusFrete(index: number, event: any) {
    try {
      const frete = this.freteList[index];
      frete.statusFrete = event.target.value;
      await this.freteClient.update(frete);
      this.listarFretes();
    } catch (error) { }
  }

  public statusFaturado(event: any){
    try {
      this.freteClient.updateStatusFaturado(event.target.value)
      this.listarFretes()
    } catch (error: any) {
      console.log(error);
    }
  }

  //   public getStatusFreteName(status: StatusFrete) {
  //     return StatusFrete[status];
  //   }
}
</script>

<style>
.center {
  display: flex;
  flex-direction: row;
  flex-grow: 1;
  justify-content: center;
}

.form {
  padding: 20px;
  border: 1px solid black;
  margin: 20px;
  width: 25%;
  display: flex;
  flex-direction: column;
}

table {
  border: 1px solid black;
  border-collapse: collapse;
}

th {
  border: 1px solid black;
  padding: 10px;
}

.inputDiv {
  display: flex;
  margin-top: 15px;
  justify-content: space-between;
}

button {
  margin-top: 15px;
}

p {
  margin-right: 10px;
}

.error {
  border-color: red;
}

.normal {
  border-color: black;
}

.table {
  display: flex;
  flex-direction: row;
}
</style>
