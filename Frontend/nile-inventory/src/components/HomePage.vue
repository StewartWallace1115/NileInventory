
<template>
    <div class="row">
        <div class="col-md-12">
            <h3>Cat Facts</h3>
        </div>
        <div class="col-md-12">
            <ul class="list-group">
                <li v-for="(fact, index) in catFacts" :key="index" class="list-group-item">{{index + 1}}. {{fact.name}}</li>
            </ul>
        </div>
        <div class="row mt-3">
            <div class="col-md-12 text-center">
                <button @click="loadMoreFacts" class="btn btn-md btn-primary">{{ fetchingFacts ? '...' : 'Load more' }}</button>
            </div>
        </div>
    </div>
</template>
<script lang="ts">
    import { defineComponent } from 'vue'
    import axios from 'axios';
    interface AnimalFacts {
        name: string
    }
    export default defineComponent({
        name: 'AnimalFacts',
        data() {
            return {
                catFacts: [] as AnimalFacts[],
                fetchingFacts: false
            }
        },
        methods: {
            async fetchCatFacts() {
                const catFactsResponse = await axios.get<AnimalFacts[]>('http://localhost:8080/api/v1/product')
                this.catFacts = catFactsResponse.data
            },
            async loadMoreFacts() {
                this.fetchingFacts = true
                const catFactsResponse = await axios.get<AnimalFacts[]>('http://localhost:8080/api/v1/product')
                this.catFacts.push(...(catFactsResponse.data || []))
                console.log(this.catFacts)
                this.fetchingFacts = false
            }
        },
        async mounted() {
            await this.fetchCatFacts()
        }
    })
</script>