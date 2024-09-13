import {Routes, Route} from 'react-router-dom'
import NewsPage from './pages/NewsPage';

function App() {

  return (
    <Routes>
      <Route index element={<NewsPage/>}/>
      <Route path='/:category' element={<NewsPage/>}/> {/**path에 매핑시킨 key 값을 꺼낼 때에도 키값과 동일한 이름으로 꺼내야 한다. */}
    </Routes>
  );
}

export default App;
