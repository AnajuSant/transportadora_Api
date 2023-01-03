<template>
  <div class="form">
    <div class="inputDiv">
      <p>Estado Origem:</p>
      <select @change="changeEstadoOrigem($event)">
        <option hidden disabled selected>ESCOLHA</option>
        <option v-for="estado in estadoOrigem" :value="estado.id">
          {{ estado.nome }}
        </option>
      </select>
    </div>
    <div class="inputDiv">
      <p>Cidade origem:</p>
      <select @change="changeCidadeOrigem($event)">
        <option hidden disabled selected>ESCOLHA</option>
        <option v-for="cidade in cidadesOrigem" :value="cidade.id">
          {{ cidade.nome }}
        </option>
      </select>
    </div>
    <div class="inputDiv">
      <p>Estado destino:</p>
      <select @change="changeEstadoDestino($event)">
        <option hidden disabled selected>ESCOLHA</option>
        <option v-for="estado in estadoDestino" :value="estado.id">
          {{ estado.nome }}
        </option>
      </select>
    </div>
    <div class="inputDiv">
      <p>Cidade Destino:</p>
      <select @change="changeCidadeDestino($event)">
        <option hidden disabled selected>ESCOLHA</option>
        <option v-for="cidade in cidadesDestino" :value="cidade.id">
          {{ cidade.nome }}
        </option>
      </select>
    </div>
    <div class="inputDiv">
      <p>Motorista:</p>
      <select @change="changeMotorista($event)">
        <option hidden disabled selected>ESCOLHA</option>
        <option v-for="motorista in motoristas" :value="motorista.id">
          {{ motorista.nome }}
        </option>
      </select>
    </div>
    <div class="inputDiv">
      <p>Produto:</p>
      <select @change="changeProduto($event)">
        <option hidden disabled selected>ESCOLHA</option>
        <option v-for="produto in produtos" :value="produto.id">
          {{ produto.nome }}
        </option>
      </select>
    </div>
    <div class="inputDiv">
      <p>Caminhao:</p>
      <select @change="changeCaminhao($event)">
        <option hidden disabled selected>ESCOLHA</option>
        <option v-for="caminhao in caminhoes" :value="caminhao.id">
          {{ caminhao.placa }}
        </option>
      </select>
    </div>
    <div class="inputDiv">
      <p>Preço por tonelada:</p>

      <input v-model="frete.precoTonelada" />
    </div>
    <button @click="SendData">Salvar</button>
  </div>
</template>

<script lang="ts">
import { FreteClient } from "@/client/Frete.client";
import { CidadeClient } from "@/client/Cidade.client";
import { Cidade } from "@/model/Cidade";
import { Frete } from "@/model/Frete";
import { Vue } from "vue-class-component";
import { CaminhaoClient } from "@/client/Caminhao.client";
import { Caminhao } from "@/model/Caminhao";
import { UserClient } from "@/client/User.client";
import { ProdutoClient } from "@/client/Produto.client";
import { User } from "@/model/User";
import { Produto } from "@/model/Produto";
import { EstadoClient } from "@/client/Estado.client";

interface ErrorFrete {
  cidadeOrigem: boolean;
  cidadeDestino: boolean;
  produto: boolean;
  caminhao: boolean;
  motorista: boolean;
  tonelada: boolean;
}

export default class FreteForm extends Vue {
  public freteClient: FreteClient = new FreteClient();
  public cidadeClient: CidadeClient = new CidadeClient();
  public estadoClient: EstadoClient = new EstadoClient();
  public caminhaoClient: CaminhaoClient = new CaminhaoClient();
  public userClient: UserClient = new UserClient();
  public produtoClient: ProdutoClient = new ProdutoClient();

  public frete: Frete = new Frete();
  public errorFrete: ErrorFrete = {
    cidadeOrigem: false,
    cidadeDestino: false,
    produto: false,
    caminhao: false,
    motorista: false,
    tonelada: false,
  };

  public estadoOrigem: Cidade[] = [];
  public cidadesOrigem: Cidade[] = [];
  public estadoDestino: Cidade[] = [];
  public cidadesDestino: Cidade[] = [];
  public caminhoes: Caminhao[] = [];
  public motoristas: User[] = [];
  public produtos: Produto[] = [];

  public mounted(): void {
    this.getEstados();
    this.getCaminhoes();
    this.getMotoristas();
    this.getProdutos();
    console.log(this.estadoOrigem);
  }

  private async getEstados() {
    this.estadoOrigem = await this.estadoClient.findAll();
    this.estadoDestino = await this.estadoClient.findAll();
  }

  private async getCidades(id: number) {
    this.cidadesOrigem = await this.cidadeClient.findByState(id);
  }

  private async getCaminhoes() {
    this.caminhoes = await this.caminhaoClient.findAll();
  }

  private async getMotoristas() {
    this.motoristas = await this.userClient.findAll();
  }

  private async getProdutos() {
    this.produtos = await this.produtoClient.findAll();
  }

  public async changeEstadoOrigem(event: any) {
    this.cidadesOrigem = await this.cidadeClient.findByState(
      event.target.value
    );
  }

  public async changeEstadoDestino(event: any) {
    this.cidadesDestino = await this.cidadeClient.findByState(
      event.target.value
    );
  }

  public changeCidadeOrigem(event: any) {
    console.log(event.target.value);
    this.frete.cidadeOrigem = event.target.value;
  }

  public changeCidadeDestino(event: any) {
    this.frete.cidadeDestino = event.target.value;
  }

  public changeProduto(event: any) {
    this.frete.produto = event.target.value;
  }

  public changeMotorista(event: any) {
    this.frete.motorista = event.target.value;
  }

  public changeCaminhao(event: any) {
    this.frete.caminhao = event.target.value;
  }

  public goBack() {
    this.$router.push("/listagem");
  }

  public SendData(): void {
    let hasError = false;
    if (!this.frete.cidadeOrigem) {
      hasError = true;
      this.errorFrete.cidadeOrigem = true;
    }
    if (!this.frete.cidadeDestino) {
      hasError = true;
      this.errorFrete.cidadeDestino = true;
    }
    if (!this.frete.produto) {
      hasError = true;
      this.errorFrete.produto = true;
    }
    if (!this.frete.caminhao) {
      hasError = true;
      this.errorFrete.caminhao = true;
    }
    if (!this.frete.motorista) {
      hasError = true;
      this.errorFrete.motorista = true;
    }
    if (!this.frete.precoTonelada) {
      hasError = true;
      this.errorFrete.tonelada = true;
    }
    this.SendFrete();
  }

  private async SendFrete() {
    try {
      let data = {
        caminhao: {
          id: this.frete.caminhao
        },
        cidadeOrigem: {
          id: this.frete.cidadeOrigem
        },
        cidadeDestino: {
          id: this.frete.cidadeDestino
        },
        motorista: {
          id: this.frete.motorista
        },
        precoTonelada: this.frete.precoTonelada,
        produto: {
          id: this.frete.produto
        },
      };
      await this.freteClient.create(data);
      this.goBack();
    } catch (error) { }
  }

  //   public RemoveError(fieldname: string) {
  //     this.errorFrete[fieldname as keyof ErrorFrete] = false;
  //   }
}
</script>

<style scoped>
.form {
  padding: 20px;
  margin: 20px;
  width: 25%;
  display: flex;
  flex-grow: 1;
  flex-direction: column;
  justify-content: center;
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

/* 
.normal {
  border-color: black;
} */
</style>
