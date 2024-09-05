import logo from './logo.svg';
import './App.css';
import Test, {add} from './Test'; // export default 아닌 export로 되어 있는 것들은 {}로 import 할 수 있다.
import StateOfComponent from '../../first-react-app/src/components/StateOfComponent';

function App() {
  return (
    <>
      <StateOfComponent/>
    </>
  );
}

export default App;
