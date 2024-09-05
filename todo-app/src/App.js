import TodoInsert from "./components/TodoInsert";
import TodoList from "./components/TodoList";
import TodoTemplate from "./components/TodoTemplate";
import {useState, useRef, useCallback} from 'react';

function App() {
  const [todos, setTodos] = useState([
    {
      id:1,
      text:'리액트 공부하기',
      checked: true
    },
    {
      id:2,
      text:'자바스크립트 공부하기',
      checked: true
    },
    {
      id:3,
      text:'Spring Boot 공부하기',
      checked: true
    },
  ]);

  const todoId = useRef(4);

   // 할 일을 추가하는 메소드
   const addTodo = useCallback((text) => {
    const newTodo = {
      id:todoId.current,
      text: text,
      checked: false
    }

    setTodos(
      todos.concat(newTodo) // todos에 newTodo 저장(추가)
    );

    todoId.current += 1; // 아이디값 1씩 증가
   }, [todos])

   const removeId = useCallback((id) => {
      setTodos(
        todos.filter(todos => (todos.id !== id)) // 화살표함수, 람다식은 {} 열면 안에 return문 필요, () or 괄호 없는 경우는 바로 return되기 때문에 return문을 쓰지 않아도 된다. 
      );  

      console.log(todos[0].id);
   }, [todos]);

   const checkedId = useCallback((id) => {
      setTodos(
        todos.map()
      );

   }, [todos])

  return (
    <TodoTemplate>
      <TodoInsert addTodo={addTodo}/>
      <TodoList todos={todos} removeId={removeId}/>
    </TodoTemplate>
  );
};

export default App;
