package com.opnx.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Type of order to submit to the system.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderType {
  LIMIT,
  STOP,
  STOP_LIMIT,
  STOP_MARKET,
  MARKET
}
