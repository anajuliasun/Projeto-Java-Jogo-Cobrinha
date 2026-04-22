# 🧵 Laboratório de Programação Concorrente em Java

Este repositório apresenta a implementação prática dos principais conceitos de **programação concorrente em Java**, explorando desde condições de corrida até aplicações com interface gráfica e game loop.

---

## 📊 Visão Geral

O objetivo deste laboratório é demonstrar como a **Máquina Virtual Java (JVM)** gerencia múltiplas threads e como isso impacta diretamente na **consistência dos dados** e na **responsividade das aplicações**.

As atividades estão divididas em três partes:

- ⚠️ Condição de Corrida (Threads)
- 🖥️ Responsividade com Swing (EDT)
- 🐍 Game Loop com TimerTask

---

## ⚠️ Parte 1 — Condição de Corrida

Nesta etapa, simulamos o problema clássico de **condição de corrida**, onde múltiplas threads acessam e modificam uma mesma variável compartilhada.

### 🔍 Conceitos abordados:
- Criação de threads com `Runnable`
- Compartilhamento de recurso (`Contador`)
- Uso de `Thread.sleep()` para simular concorrência
- Sincronização com `synchronized`
- Controle de execução com `join()`

### 💡 Resultado:
Sem sincronização, o valor final do contador é inconsistente.  
Com `synchronized`, garantimos **exclusão mútua** e o resultado correto.

---

## 🖥️ Parte 2 — Threads e Interface Gráfica (Swing)

Nesta etapa, exploramos o funcionamento da **Event Dispatch Thread (EDT)** no Swing.

### 🔍 Problema:
Executar tarefas pesadas diretamente na EDT causa **travamento da interface**.

### ✅ Solução:
Utilização de uma **thread em background** para executar tarefas demoradas.

### 🔍 Conceitos abordados:
- Event Dispatch Thread (EDT)
- Responsividade da interface
- Uso de `Thread` para tarefas paralelas
- Atualização de componentes gráficos

### 💡 Resultado:
A interface permanece **fluida e responsiva**, mesmo durante operações demoradas.

---

## 🐍 Parte 3 — Game Loop com TimerTask

Implementação de um **Game Loop** utilizando `Timer` e `TimerTask`, aplicado ao jogo da cobrinha.

### 🔍 Conceitos abordados:
- Execução periódica com `TimerTask`
- Estrutura de dados (`LinkedList`)
- Manipulação de coordenadas (plano cartesiano)
- Atualização gráfica com `repaint()`
- Captura de eventos de teclado

### 🎮 Funcionalidades:
- Movimento contínuo da cobra
- Crescimento ao consumir a maçã
- Sistema de pontuação
- Atualização em tempo real

### 💡 Resultado:
O jogo roda de forma contínua e fluida, demonstrando concorrência entre lógica e renderização.

---

## 🧠 Conclusão

Este laboratório evidencia a importância da programação concorrente para:

- ✔ Evitar inconsistência de dados
- ✔ Melhorar a performance
- ✔ Garantir interfaces responsivas
- ✔ Organizar tarefas assíncronas

---

## 🚀 Tecnologias Utilizadas

- Java
- Swing
- Threads
- Timer / TimerTask

---

## 👩‍💻 Autor

Projeto desenvolvido para fins acadêmicos na disciplina de Programação Concorrente.
