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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = { "/api" })
public class ApiController {

  @Autowired
  MailService mailService;

  // This method updates the password for same user only
  @RequestMapping("/misc/contact/")
  public ResponseEntity<?> contact( //
      @RequestParam("name") String name, //
      @RequestParam("email") String email, //
      @RequestParam("school") String school, //
      @RequestParam("position") String position, //
      @RequestParam("message") String message//
  ) {

    sendContactMail(new String[] { "gpimpale29@gmail.com", "innexgo@gmail.com" }, //
        "Innexgo Sales: New Contact", //
        "New contact from form:<br/>" + //
            "name: <code>" + name + "</code><br/>" + //
            "email: <code>" + email + "</code><br/>" + //
            "school: <code>" + school + "</code><br/>" + //
            "position: <code>" + position + "</code><br/>" + //
            "message: <code>" + message + "</code><br/>" //
    );

    return Errors.OK.getResponse();
  }

  private void sendContactMail(String[] dests, String subject, String body) {
    for (String dest : dests) {
      mailService.send(dest, subject, body);
    }
  }
}
