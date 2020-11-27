/*
 * Innexgo Website
 * Copyright (C) 2020 Innexgo LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package innexgo.hours;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public enum Errors {
  OK(HttpStatus.OK),
  NOT_FOUND(HttpStatus.NOT_FOUND),
  UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR);

  private final HttpStatus httpStatus;

  private Errors(HttpStatus status) {
    this.httpStatus = status;
  }

  public ResponseEntity<?> getResponse() {
    return new ResponseEntity<>("\"" + this.name() + "\"", httpStatus);
  }
}
