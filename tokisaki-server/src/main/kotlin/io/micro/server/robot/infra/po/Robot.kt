package io.micro.server.robot.infra.po

import io.micro.core.persistence.BasePO
import io.micro.server.auth.infra.po.User
import jakarta.persistence.*

@Table(name = "tokisaki_robot")
@Entity
class Robot : BasePO() {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null

    @Column(name = "robot_name", nullable = false)
    var name: String? = null

    @Column(name = "robot_account", nullable = false)
    var account: String? = null

    @Column(name = "robot_authorization")
    var authorization: String? = null

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "robot_type", nullable = false)
    var type: Type? = null

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "robot_state", nullable = false)
    var state: State? = null

    @Column(name = "robot_remark")
    var remark: String? = null

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "use_function_id")
    var functions: MutableSet<UseFunction>? = null

    enum class Type { QQ }

    enum class State {
        Create,
        LoggingIn,
        LoggingFail,
        Online,
        Offline,
        Closed,
        ALL
    }

}