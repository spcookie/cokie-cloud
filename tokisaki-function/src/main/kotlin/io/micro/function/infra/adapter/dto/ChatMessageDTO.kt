package io.micro.function.infra.adapter.dto

import kotlinx.serialization.Serializable


/**
 * <p>Each object has a role (either "system", "user", or "assistant") and content (the content of the message). Conversations can be as short as 1 message or fill many pages.</p>
 * <p>Typically, a conversation is formatted with a system message first, followed by alternating user and assistant messages.</p>
 * <p>The system message helps set the behavior of the assistant. In the example above, the assistant was instructed with "You are a helpful assistant."<br>
 * The user messages help instruct the assistant. They can be generated by the end users of an application, or set by a developer as an instruction.<br>
 * The assistant messages help store prior responses. They can also be written by a developer to help give examples of desired behavior.
 * </p>
 *
 * see <a href="https://platform.openai.com/docs/guides/chat/introduction">OpenAi documentation</a>
 */
@Serializable
data class ChatMessageDTO(
    /**
     * Must be either 'system', 'user', 'assistant' or 'function'.<br></br>
     * You may use [ChatMessageRole] enum.
     */
    var role: String? = null,

    // content should always exist in the call, even if it is null
    var content: String? = null,

    //name is optional, The name of the author of this message. May contain a-z, A-Z, 0-9, and underscores, with a maximum length of 64 characters.
    var name: String? = null,
)
