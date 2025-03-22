<template>
    <div class="tabela-container">
      <h1>Atividades</h1>
      <table class="tabela">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Status</th>
            <th>Ação</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="task in tasks" :key="task.id" class="tabela-linha">
            <td>{{ task.id }}</td>
            <td>{{ task.nome }}</td>
            <td>{{ task.descricao }}</td>
            <td>{{ task.status }}</td>
            <td>
              <button @click="editTask(task)">Editar</button>
              <button @click="deleteTask(task.id)">Deletar</button>
            </td>
          </tr>
        </tbody>
      </table>
        
      <!-- Formulario de Edição -->
      <div v-if="isEditing">
        <h2>Editar Atividade</h2>
        <form @submit.prevent="saveEditedTask">
          <input v-model="editedTask.id" placeholder="id" type="number" step="1" required />
          <input v-model="editedTask.nome" placeholder="Nome" required />
          <input v-model="editedTask.descricao" placeholder="Descrição" required />
          <input v-model="editedTask.status" placeholder="Status" required />
          <button type="submit">Salvar</button>
          <button type="button" @click="cancelEdit">Cancelar</button>
        </form>
      </div>
      <!-- Formulário para Adicionar -->
      <h2>Adicionar Atividade</h2>
      <form @submit.prevent="addTask">
        <input v-model="newTask.id" placeholder="id" type="number" step="1" required />
        <input v-model="newTask.nome" placeholder="Nome" required />
        <input v-model="newTask.descricao" placeholder="Descrição" required />
        <input v-model="newTask.status" placeholder="Status" required />
        <button type="submit">Adicionar</button>
      </form>
    </div>
</template>
  
<script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const tasks = ref([]);
  const newTask = ref({id: 0, nome: '', descricao: '', status: ''});
  const isEditing = ref(false);
  const editedTask = ref({id: null, nome: '', descricao: '', status: ''});
  
  const fetchTasks = async () => {
    try {
      const response = await axios.get('http://localhost:8080/task');
      tasks.value = response.data;
    } catch (error) {
      console.error('Erro ao buscar atividades:', error);
    }
  };
  
  const addTask = async () => {
    try {
      await axios.post('http://localhost:8080/task', newTask.value);
      newTask.value = { id: 0, nome: '', descricao: '', status: ''};
      fetchTasks();
    } catch (error) {
      console.error('Erro ao adicionar atividade:', error);
    }
  };

  const editTask = (task) => {
    isEditing.value = true;
    editedTask.value = { ...task }; // Copia os dados da atividade para o formulário de edição
  };

  const saveEditedTask = async () => {
    try {
      await axios.put(`http://localhost:8080/task/${editedTask.value.id}`, editedTask.value);
      isEditing.value = false; // Fecha o modal
      await fetchTasks(); // Atualiza a lista
    } catch (error) {
      console.error('Erro ao editar atividade:', error);
    }
  }; 

  const cancelEdit = () => {
    isEditing.value = false;
  };

  const deleteTask = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/task/${id}`);
      fetchTasks();
    } catch (error) {
      console.error('Erro ao deletar produto:', error);
    }
  };
  
  onMounted(() => {
    fetchTasks();
  });
</script>

<style scoped>
.tabela-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.tabela {
  width: 100%;
  border-collapse: collapse;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.tabela th,
.tabela td {
  padding: 12px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.tabela th {
  background-color: #f8f9fa;
  font-weight: bold;
}

.tabela-linha:hover {
  background-color: #f1f1f1;
}
</style>