/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package RestFull_Webservice_Karaf.TestRestServiceKaraf;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public interface CustomerService {

	/**
	 * Cette m�thode est mapp�e � une requ�te HTTP GET :
	 * "http://localhost:8181/cxf/olivier/customers/{id}". La valeur de {id} sera
	 * pass�e en param�tre � la m�thode par utilisation de l'annotation @PathParam.
	 * <p/>
	 * La m�thode retournera un objet de la classe CustomerBean par cr�ation d'une
	 * r�ponse HTTP. Cet objet sera transform� en XML par JAXB.
	 * <p/>
	 * Par exemple, l'appel de l'URL
	 * "http://localhost:8181/cxf/olivier/customers/123" provoquera l'affichage du
	 * customer 123 au format XML.
	 */
	@GET
	@Path("/customers/{id}/")
	@Produces("application/xml")
	public CustomerBean getCustomer(@PathParam("id") String id);

	/**
	 * Cette m�thode est mapp�e � une requ�te HTTP PUT. On peut ainsi envoyer la
	 * repr�sentation XML d'un objet customerBean. La repr�sentation XML sera
	 * obtenue par transformation d'un CustomerBean par JAXB.
	 * <p/>
	 * Cette m�thode met � jour un objet CustomerBean dans notre map locale puis
	 * utilise la classe Response pour construire une r�ponse HP appropri�e : soit
	 * OK si la mise � jour a �t� effectu�e avec succ�s (Traduction du statut HTTP
	 * 200/OK) ou NON MODIFIE si la mise � jour de l'objet CustomerBean a �chou�
	 * (Traduction du statut HTTP 304/Not Modified).
	 * <p/>
	 * � NOTER : cette m�thode utilise la m�me valeur de @path que la m�thode
	 * suivante. La m�thode HTTP utilis�e d�terminera quelle sera la m�thode �
	 * invoquer
	 * 
	 */
	@PUT
	@Path("/customers/")
	@Consumes({ "application/xml", "application/json" })
	public Response updateCustomer(CustomerBean customer);

	/**
	 * Utilisation de la requ�te HTTP POST permettant d'ajouter un nouveau customer
	 * au syst�me en uploadant la repr�sentation XML d'un objet CustomerBean. Cette
	 * op�ration sera mapp�e � la m�thode ci-dessous et la repr�sentation XML sera
	 * transform�e en un objet CustomerBean.
	 * <p/>
	 * Apr�s que cette m�thode aura ajout� le client dans la map local, elle
	 * utilisera la classe Response pour construire la r�ponse HTTP en retournant �
	 * la fois l'objet CustomerBean ins�r� et le statut HTTP 200/OK. Ceci permet de
	 * r�cup�rer l'ID du nouvel objet CustomerBean.
	 * <p/>
	 * � NOTER : cette m�thode utilise la m�me valeur de @path que la m�thode
	 * pr�c�dente. La m�thode HTTP utilis�e d�terminera quelle sera la m�thode �
	 * invoquer
	 */
	@POST
	@Path("/customers/")
	@Consumes({ "application/xml", "application/json" })
	public Response addCustomer(CustomerBean customer);

	/**
	 * Cette m�thode est mapp�e � une requ�te HTTP DELETE du type :
	 * "http://localhost:8181/cxf/olivier/customers/{id}". La valeur pour {id} sera
	 * pass�e en tant que param�tre en utilisant l'annotation @PathParam.
	 * <p/>
	 * Cette m�thode utilise la classe Response pour cr�er une r�ponse HTTP : soit
	 * le statut HTTP 200/OK si l'objet CustomerBean a �t� correctement supprim� de
	 * la map locale, soit le statut HTTP 304/Not Modified si la suppression a
	 * �chou�.
	 */
	@DELETE
	@Path("/customers/{id}/")
	public Response deleteCustomer(@PathParam("id") String id);

	/**
	 * Cette m�thode est mapp�e � une requ�te HTTP GET du type :
	 * "http://localhost:8181/cxf/olivier/orders/{id}". La valeur pour {id} sera
	 * pass�e en tant que param�tre en utilisant l'annotation @PathParam.
	 * <p/>
	 * La m�thode retournera un objet de la classe Product par cr�ation d'une
	 * r�ponse HTTP. Cet objet sera transform� en XML par JAXB.
	 * <p/>
	 * Par exemple, l'appel de l'URL "http://localhost:8181/cxf/olivier/orders/223"
	 * provoquera l'affichage du customer 123 au format XML.
	 */
	@GET
	@Path("/orders/{orderId}")
	@Produces("application/xml")
	public OrderBean getOrder(@PathParam("orderId") String orderId);

	/**
	 * Cette m�thode est mapp�e � une requ�te HTTP GET du type :
	 * "http://localhost:8181/cxf/olivier/orders/{id}/products/{productId}". La
	 * valeur pour {id} et {productId} sera pass�e en tant que param�tre en
	 * utilisant l'annotation @PathParam.
	 * <p/>
	 * La m�thode retournera un objet de la classe Product par cr�ation d'une
	 * r�ponse HTTP. Cet objet sera transform� en XML par JAXB.
	 * <p/>
	 * Par exemple, l'appel de l'URL
	 * "http://localhost:8181/cxf/olivier/orders/223/products/323/" provoquera
	 * l'affichage du customer 123 au format XML.
	 */
	@GET
	@Path("/orders/{orderId}/products/{productId}")
	@Produces("application/xml")
	public Product getProduct(@PathParam("orderId") String orderId, @PathParam("productId") int productId);

	/**
	 * Cette m�thode est mapp�e � une requ�te HTTP GET du type :
	 * "http://localhost:8181/cxf/olivier/orders/{id}/products". La valeur pour {id}
	 * sera pass�e en tant que param�tre en utilisant l'annotation @PathParam.
	 * <p/>
	 * La m�thode retournera un objet de la classe Product par cr�ation d'une
	 * r�ponse HTTP. Cet objet sera transform� en XML par JAXB.
	 * <p/>
	 * Par exemple, l'appel de l'URL
	 * "http://localhost:8181/cxf/olivier/orders/223/products/323/" provoquera
	 * l'affichage du customer 123 au format XML.
	 */
	@GET
	@Path("/orders/{orderId}/products")
	@Produces("application/xml")
	public Products getProducts(@PathParam("orderId") String orderId);

}