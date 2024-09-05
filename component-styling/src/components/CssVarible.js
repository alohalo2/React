import React, {useState, useEffect} from 'react';

const CssVarible = () => {
    // 스타일 객체로 선언해서 DOM의 style 속성에 전달
    const [style, setStyle] = useState({textAlign: 'center', color: 'red', backgroundColor: 'gray', fontSize: '48px'});
    
    useEffect(() => {
        setTimeout(() => {
            setStyle({textAlign: 'left', color: 'blue', backgroundColor: 'yellow', fontSize: '12px'});
        },1000);
    }, []);

  return (
    <>
        <p style={style}>Component Styling</p>
    </>
  );
};

export default CssVarible;