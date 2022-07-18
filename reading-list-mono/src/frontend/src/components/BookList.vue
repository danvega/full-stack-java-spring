<script setup>
import { onMounted, ref } from 'vue';

const books = ref([]);

onMounted(() => {
  fetch('/api/books')
    .then(response => response.json())
    .then(data => {
      books.value = data;
    });
});
</script>

<template>

  <div class="container mx-auto">
    <h1 class="text-3xl font-bold py-4">Reading List</h1>
    <p>This is a collection of books I am curently reading or hope to read soon.</p>

    <div class="flex flex-col">
      <div class="overflow-x-auto sm:-mx-6 lg:-mx-8">
        <div class="py-2 inline-block min-w-full sm:px-6 lg:px-8">
          <div class="overflow-hidden">
            <table class="min-w-full">
              <thead class="bg-white border-b">
                <tr>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    #
                  </th>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    Title
                  </th>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    Author
                  </th>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    Pages
                  </th>
                  <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                    Status
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(book, index) in books" :key="book.id" :class="index % 2 === 0 ? 'bg-gray-100' : 'bg-white'"
                  class="border-b">
                  <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{{ book.id }}</td>
                  <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {{ book.title }}
                  </td>
                  <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {{ book.author }}
                  </td>
                  <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {{ book.pages }}
                  </td>
                  <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {{ book.status }}
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<style>
</style>
