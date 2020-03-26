import React, {useCallback, useMemo, useState} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import GoogleMapReact from 'google-map-react';
import HealthCheckInModal from './ui/HealthCheckInModal';
import {useApiState} from './providers/ApiProvider';
import {Button} from '@material-ui/core';

const useStyles = makeStyles({
  header: {
    backgroundColor: '#00c5b3',
    color: 'white',
    padding: 10,
  },
  headerTitle: {
    fontSize: 24,
  },
  content: {
    flex: 1,
  },
  root: {
    display: 'flex',
    flexDirection: 'column',
    height: '100%',
  },
  overview: {
    display: 'flex',
    height: '100%',
    maxHeight: 500,
  },
  overviewMapLegend: {
    minWidth: 400,
  },
});

export default function App(): JSX.Element {
  const styles = useStyles();
  const {serverInfo} = useApiState();
  const [showCheckin, setShowCheckin] = useState(false);
  const toggleCheckin = useCallback(() => {
    setShowCheckin(!showCheckin);
  }, [showCheckin]);

  const [map, setMap] = useState<google.maps.Map>();

  const heatmapData = useMemo(() => {
    if (map) {
      const heatmap = new google.maps.visualization.HeatmapLayer();
      heatmap.setOptions({
        data: [],
        radius: 20,
        opacity: 0.5,
      });
      heatmap.setData(
        new google.maps.MVCArray([
          {location: new google.maps.LatLng(55.5, 34.6), weight: 1},
          {location: new google.maps.LatLng(55.9, 34.0), weight: 1},
        ])
      );
      heatmap.setMap(map);
      return heatmap;
    } else {
      return undefined;
    }
  }, [map]);

  const untypedProps = {heatmap: heatmapData};

  return (
    <div className={styles.root}>
      <div className={styles.header}>
        <span className={styles.headerTitle}>Temp Tracker</span>
      </div>
      <div className={styles.content}>
        {showCheckin ? <HealthCheckInModal onDismiss={toggleCheckin} /> : null}
        <div className={styles.overview}>
          <GoogleMapReact
            defaultCenter={{lat: 55.5, lng: 34.56}}
            defaultZoom={7}
            heatmapLibrary={true}
            onGoogleApiLoaded={maps => setMap(maps.map)}
            yesIWantToUseGoogleMapApiInternals={true}
            bootstrapURLKeys={{
              key: serverInfo.mapsApiKey,
              libraries: ['visualization'],
            }}
            {...untypedProps}
          />
          <div className={styles.overviewMapLegend}>
            <Button variant={'contained'} onClick={toggleCheckin}>
              Check in
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
}
