import React from 'react';
import '../scss/TodoTemplate.scss';

const TodoTemplate = (props) => {
  return (
    <div className='TodoTemplate'>
        <div className='app-title'>일정관리</div>
        <div className='content'>{props.children}</div>
    </div>
  );
};

export default TodoTemplate;