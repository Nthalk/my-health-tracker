/* tslint:disable */
/* eslint-disable */

export interface CheckIn {
  temperature: number;
}

export interface ServerInfoResponse {
  mapsApiKey: string;
}

export interface ApiError {
  code: ErrorCode;
  message: string;
  stack: string;
}

export interface ApiResult<T> {
  result?: T | null;
  error?: RootApiError | null;
}

export interface RootApiError {
  code: ErrorCode;
  message: string;
  stack?: string | null;
  fieldErrors?: {[index: string]: ApiError};
  globalErrors?: ApiError[];
}

export interface Unit {}

export interface HttpClient {
  request<R>(requestConfig: {
    method: string;
    url: string;
    queryParams?: any;
    data?: any;
    copyFn?: (data: R) => R;
  }): RestResponse<R>;
}

export class HealthCheckApiClient {
  constructor(protected httpClient: HttpClient) {}

  /**
   * HTTP POST /api/health-check/check-in
   * Java method: com.nthalk.healthtracker.web.api.HealthCheckApi.checkIn
   */
  checkIn(arg0: CheckIn): RestResponse<ApiResult<Unit>> {
    return this.httpClient.request({
      method: 'POST',
      url: uriEncoding`api/health-check/check-in`,
      data: arg0,
    });
  }
}

export class ServerApiClient {
  constructor(protected httpClient: HttpClient) {}

  /**
   * HTTP POST /api/test
   * Java method: com.nthalk.healthtracker.web.api.ServerApi.info
   */
  info(): RestResponse<ApiResult<ServerInfoResponse>> {
    return this.httpClient.request({
      method: 'POST',
      url: uriEncoding`api/test`,
    });
  }
}

export type RestResponse<R> = Promise<R>;

export type ErrorCode = 'UNKNOWN';

function uriEncoding(
  template: TemplateStringsArray,
  ...substitutions: any[]
): string {
  let result = '';
  for (let i = 0; i < substitutions.length; i++) {
    result += template[i];
    result += encodeURIComponent(substitutions[i]);
  }
  result += template[template.length - 1];
  return result;
}
