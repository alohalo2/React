import React from 'react';
import TodoListItem from './TodoListItem';
import '../scss/TodoList.scss';

const TodoList = ({todos, removeId}) => {
  return (
    <div className='TodoList'>
        {todos && todos.map(todo => 
          <TodoListItem key={todo.id} todo={todo} removeId={removeId}/> // 반복적으로 만들어주는 태그나 속성에는 key 속성을 무조건 넣어줘야 한다.
        )}
    </div>
  );
};

export default TodoList;