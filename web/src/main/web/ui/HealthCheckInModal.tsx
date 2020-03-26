import React, {useCallback} from 'react';
import {
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  DialogTitle,
} from '@material-ui/core';
import {useSessionManager} from '../providers/SessionProvider';

export default function HealthCheckInModal(props: {
  onDismiss: () => void;
}): JSX.Element {
  const sessionManager = useSessionManager();

  const detectLocation = useCallback(
    _$event => {
      window.navigator.geolocation.getCurrentPosition(
        pos => {
          sessionManager.update({
            gps: {lat: pos.coords.latitude, lng: pos.coords.longitude},
          });
        },
        er => {
          console.log(er.code, er.message);
        }
      );
    },
    [sessionManager]
  );

  return (
    <Dialog open={true} onClose={props.onDismiss}>
      <DialogTitle>Location and Health Check-In</DialogTitle>
      <DialogContent>
        <DialogContentText>
          To help contribute to the health dataset, your gps location is
          required. However, this value will be randomized within 2 miles of
          your location.
        </DialogContentText>
        <Button variant={'outlined'} color={'primary'} onClick={detectLocation}>
          Locate Me
        </Button>
      </DialogContent>
      <DialogActions>
        <Button variant={'contained'} color={'primary'}>
          Submit health check in
        </Button>
      </DialogActions>
    </Dialog>
  );
}
