import React from 'react';

import SessionProvider from './providers/SessionProvider';
import {ApiProvider} from './providers/ApiProvider';
import {BrowserRouter} from 'react-router-dom';
import App from './App';
import {CssBaseline} from '@material-ui/core';

function AppLoader(): JSX.Element {
  return (
    <SessionProvider>
      <ApiProvider>
        <BrowserRouter>
          <CssBaseline />
          <App />
        </BrowserRouter>
      </ApiProvider>
    </SessionProvider>
  );
}

export default AppLoader;
