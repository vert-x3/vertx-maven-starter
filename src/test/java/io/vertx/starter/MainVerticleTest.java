package io.vertx.starter;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class MainVerticleTest {

  private Vertx vertx;

  @Before
  public void setUp(TestContext tc) {
    vertx = Vertx.vertx();
    vertx.deployVerticle(MainVerticle.class.getName(), tc.asyncAssertSuccess());
  }

  @After
  public void tearDown(TestContext tc) {
    vertx.close(tc.asyncAssertSuccess());
  }

  @Test
  public void testThatTheServerIsStarted(TestContext tc) {
    Async async = tc.async();
    vertx.createHttpClient().request(HttpMethod.GET, 8080, "localhost", "/", tc.asyncAssertSuccess(req -> {
      req.send(tc.asyncAssertSuccess(resp -> {
        tc.assertEquals(200, resp.statusCode());
        resp.body(tc.asyncAssertSuccess(body -> {
          tc.assertTrue(body.length() > 0);
          async.complete();
        }));
      }));
    }));
  }
}
