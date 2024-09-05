import React from 'react';
import { MdCheckBoxOutlineBlank, MdRemoveCircleOutline } from 'react-icons/md';
import '../scss/TodoListItem.scss';

const TodoListItem = ({todo, removeId}) => {
  return (
    <div className='TodoListItem'>
        <div className='checkbox'>
            <MdCheckBoxOutlineBlank/>
            <div className='text'>{todo.text}</div>
        </div>
        <div className='remove' onClick={() => removeId(todo.id)}>
            <MdRemoveCircleOutline/>
        </div>
    </div>
  );
};

export default TodoListItem;