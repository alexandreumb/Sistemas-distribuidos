package pt.ulisboa.tecnico.distledger.contract.distledgerserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: CrossServer_DistLedger.proto")
public final class CrossServerServiceGrpc {

  private CrossServerServiceGrpc() {}

  public static final String SERVICE_NAME = "pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest,
      pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse> getPropagateStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "propagateState",
      requestType = pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest.class,
      responseType = pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest,
      pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse> getPropagateStateMethod() {
    io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest, pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse> getPropagateStateMethod;
    if ((getPropagateStateMethod = CrossServerServiceGrpc.getPropagateStateMethod) == null) {
      synchronized (CrossServerServiceGrpc.class) {
        if ((getPropagateStateMethod = CrossServerServiceGrpc.getPropagateStateMethod) == null) {
          CrossServerServiceGrpc.getPropagateStateMethod = getPropagateStateMethod =
              io.grpc.MethodDescriptor.<pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest, pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "propagateState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CrossServerServiceMethodDescriptorSupplier("propagateState"))
              .build();
        }
      }
    }
    return getPropagateStateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CrossServerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossServerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrossServerServiceStub>() {
        @java.lang.Override
        public CrossServerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrossServerServiceStub(channel, callOptions);
        }
      };
    return CrossServerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CrossServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossServerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrossServerServiceBlockingStub>() {
        @java.lang.Override
        public CrossServerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrossServerServiceBlockingStub(channel, callOptions);
        }
      };
    return CrossServerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CrossServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossServerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrossServerServiceFutureStub>() {
        @java.lang.Override
        public CrossServerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrossServerServiceFutureStub(channel, callOptions);
        }
      };
    return CrossServerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CrossServerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void propagateState(pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPropagateStateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPropagateStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest,
                pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse>(
                  this, METHODID_PROPAGATE_STATE)))
          .build();
    }
  }

  /**
   */
  public static final class CrossServerServiceStub extends io.grpc.stub.AbstractAsyncStub<CrossServerServiceStub> {
    private CrossServerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossServerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossServerServiceStub(channel, callOptions);
    }

    /**
     */
    public void propagateState(pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPropagateStateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CrossServerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CrossServerServiceBlockingStub> {
    private CrossServerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossServerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossServerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse propagateState(pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPropagateStateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CrossServerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CrossServerServiceFutureStub> {
    private CrossServerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossServerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossServerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse> propagateState(
        pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPropagateStateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROPAGATE_STATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CrossServerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CrossServerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROPAGATE_STATE:
          serviceImpl.propagateState((pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateRequest) request,
              (io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.PropagateStateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CrossServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CrossServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pt.ulisboa.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CrossServerService");
    }
  }

  private static final class CrossServerServiceFileDescriptorSupplier
      extends CrossServerServiceBaseDescriptorSupplier {
    CrossServerServiceFileDescriptorSupplier() {}
  }

  private static final class CrossServerServiceMethodDescriptorSupplier
      extends CrossServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CrossServerServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CrossServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CrossServerServiceFileDescriptorSupplier())
              .addMethod(getPropagateStateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
