import React, {createContext, useContext, useMemo, useState} from 'react';

export type Session = {
  gps?: {lat: number; lng: number};
  token?: string;
};
export type SessionManager = {
  update: (session: Session) => void;
  clear: () => void;
};

const storedSession = JSON.parse(
  localStorage.getItem('session') || '{}'
) as Session;
export const SessionContext = createContext<Session>(null as Session);
export const SessionManagerContext = createContext<SessionManager>(
  null as SessionManager
);

export default function SessionProvider(props: {
  children: JSX.Element;
}): JSX.Element {
  const [session, setSession] = useState<Session>(storedSession);
  const sessionManager = useMemo<SessionManager>(
    () => ({
      update: (session: Session) =>
        setSession(oldSession => {
          const newSession = {
            ...oldSession,
            ...session,
          };
          setTimeout(() => {
            localStorage.setItem('session', JSON.stringify(newSession));
          });
          return newSession;
        }),
      clear: () => {
        setSession(null);
      },
    }),
    []
  );

  return (
    <SessionManagerContext.Provider value={sessionManager}>
      <SessionContext.Provider value={session}>
        {props.children}
      </SessionContext.Provider>
    </SessionManagerContext.Provider>
  );
}

export function useSession(): Session {
  return useContext(SessionContext);
}

export function useSessionManager(): SessionManager {
  return useContext(SessionManagerContext);
}
