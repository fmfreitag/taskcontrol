# Dockerfile para Nuxt.js
FROM node:22.14.0

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de dependências
COPY package*.json ./

# Instala as dependências
RUN npm install
RUN npm install axios

# Copia o restante dos arquivos do projeto
COPY . .

# Compila a aplicação
RUN npm run build

# Expõe a porta
EXPOSE 3000

# Comando para iniciar a aplicação
CMD ["npm", "run", "dev"]