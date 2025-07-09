package app.sandbox.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/sandbox")
@Tag(name = "sandbox", description = "検証用エンドポイント")
class SandBoxAppController {

  @Operation(
      operationId = "1",
      summary = "GETエンドポイント",
      description = "デフォルトのGETエンドポイント",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "成功",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SandBoxResponse.class))),
        @ApiResponse(responseCode = "400", description = "リクエスト不正", content = @Content),
        @ApiResponse(responseCode = "500", description = "サーバーエラー", content = @Content)
      })
  @GetMapping
  SandBoxResponse getDefault() {
    return new SandBoxResponse("GET えんどぽいんと");
  }

  @Operation(
      operationId = "2",
      summary = "GETエンドポイント",
      description = "パラメーター付きGETエンドポイント",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "成功",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SandBoxResponse.class))),
        @ApiResponse(responseCode = "400", description = "リクエスト不正", content = @Content),
        @ApiResponse(responseCode = "500", description = "サーバーエラー", content = @Content)
      })
  @GetMapping("/param")
  SandBoxResponse getWithParam(@RequestParam String param) {
    return new SandBoxResponse("GET えんどぽいんと parameter : " + param);
  }

  @Operation(
      operationId = "3",
      summary = "POSTエンドポイント",
      description = "POSTエンドポイント",
      requestBody =
          @io.swagger.v3.oas.annotations.parameters.RequestBody(
              description = "文字のパラメータ",
              required = true,
              content = @Content(schema = @Schema(implementation = SandBoxRequest.class))),
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "成功",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SandBoxResponse.class))),
        @ApiResponse(responseCode = "400", description = "リクエスト不正", content = @Content),
        @ApiResponse(responseCode = "500", description = "サーバーエラー", content = @Content)
      })
  @PostMapping
  SandBoxResponse post(@RequestBody SandBoxRequest request) {
    return new SandBoxResponse("POST えんどぽいんと parameter : " + request.param());
  }
}
