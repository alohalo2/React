import React from 'react';
import styled from 'styled-components';

const NewsItemBlock = styled.div`
  display: flex;

  .thumbnail {
    margin-right: 1rem;

    img {
      display: block;
      width: 160px;
      height: 100px;
      object-fit: cover;
    }
  }

  .contents {
    h2 {
      margin: 0;

      a {
        color: black;
      }
    }

    p {
      margin: 0;
      line-height: 1.5;
      margin-top: 0.5rem;
      white-space: normal;
    }
  }

  & + & {
    margin-top: 3rem;
  }
`;

const NewsItem = ({article}) => {
  const{title, description, url, urlToImage} = article // 변수명은 data에 존재하는 key 값으로 동일하게 만들어줘야 한다.

  return (
    <NewsItemBlock>
      <div className='thumbnail'>
        <a href={url} target='_blank' rel='noreferrer'>
          <img src={urlToImage} alt='기사썸네일'></img>
        </a>
      </div>
      <div className='contents'>
        <h2>
          <a href={url} target='_blank' rel='noreferer'>{title}</a>
        </h2>
        <p>{description}</p>
      </div>
    </NewsItemBlock>
  );
};

export default NewsItem;