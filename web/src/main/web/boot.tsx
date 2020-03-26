import 'core-js/stable';
import {hot} from 'react-hot-loader/root';
import ReactDOM from 'react-dom';
import React from 'react';
const AppLoader = hot(React.lazy(() => import('./AppLoader')));

ReactDOM.render(
  <React.Suspense fallback={<div>Loading...</div>}>
    <AppLoader />
  </React.Suspense>,
  document.getElementById('web')
);
