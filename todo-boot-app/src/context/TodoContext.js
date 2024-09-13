import {createContext, useState} from 'react';

const TodoContext = createContext({
    todo: [],
    setTodos: () => {}
});

export const TodoContextProvider = ({children}) => {
    const [totod, setTodos] = useState([]);

    const initialValue = {todots, setTodos};

    return (
        <TodoContextProvider value = {initialValue}>
            {children}
        </TodoContextProvider>
    );
}

export const TodoContextConsumer = TodoContext.Consumer;

export default TodoContext;