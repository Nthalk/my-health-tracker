import * as React from 'react';
import {CircularProgress, makeStyles} from '@material-ui/core';

const useClasses = makeStyles({
  root: {
    flex: 1,
    width: '100%',
    height: '100%',
    display: 'flex',
    justifyContent: 'space-around',
    alignItems: 'middle',
  },
});

export default function LoaderComponent(): JSX.Element {
  const classes = useClasses();
  return (
    <div className={classes.root}>
      <CircularProgress />
    </div>
  );
}
