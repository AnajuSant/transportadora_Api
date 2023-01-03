<template>
    <div class="form">
        <div class="inputDiv">
            <p>Km Final:</p>
            <input type="number" v-model="frete.quilometragemFim">
        </div>
        <div class="inputDiv">
            <p>Peso Final:</p>
            <input type="number" v-model="frete.pesoFinal">
        </div>
        <button @click="SendData()">Salvar</button>
    </div>
</template>
  
<script lang="ts">
import { FreteClient } from "@/client/Frete.client";
import { Frete } from "@/model/Frete";
import { Vue } from "vue-class-component";


export default class StatusTransporte extends Vue {
    public freteClient: FreteClient = new FreteClient();
    public frete: Frete = new Frete();



    public mounted(): void {
        this.findFrete()
    }

    private async findFrete(): Promise<void> {
        this.frete = await this.freteClient.findById(Number(this.$route.params.id))
        console.log(this.frete);
        if(this.frete.id === null){
            alert("Não encotrado")
            this.$router.push("/listagem");
        }
    }

    public async SendData(): Promise<void>{
        await this.freteClient.updateStatusDescarga(this.frete);
        this.$router.push("/listagem");
    }


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
  