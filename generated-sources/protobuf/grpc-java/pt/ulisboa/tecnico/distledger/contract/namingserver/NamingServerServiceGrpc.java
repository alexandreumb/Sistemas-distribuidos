package pt.ulisboa.tecnico.distledger.contract.namingserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: NamingServer_DistLedger.proto")
public final class NamingServerServiceGrpc {

  private NamingServerServiceGrpc() {}

  public static final String SERVICE_NAME = "pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest,
      pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest.class,
      responseType = pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest,
      pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest, pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = NamingServerServiceGrpc.getRegisterMethod) == null) {
      synchronized (NamingServerServiceGrpc.class) {
        if ((getRegisterMethod = NamingServerServiceGrpc.getRegisterMethod) == null) {
          NamingServerServiceGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest, pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NamingServerServiceMethodDescriptorSupplier("register"))
              .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest,
      pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> getLookupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lookup",
      requestType = pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest.class,
      responseType = pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest,
      pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> getLookupMethod() {
    io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest, pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> getLookupMethod;
    if ((getLookupMethod = NamingServerServiceGrpc.getLookupMethod) == null) {
      synchronized (NamingServerServiceGrpc.class) {
        if ((getLookupMethod = NamingServerServiceGrpc.getLookupMethod) == null) {
          NamingServerServiceGrpc.getLookupMethod = getLookupMethod =
              io.grpc.MethodDescriptor.<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest, pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "lookup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NamingServerServiceMethodDescriptorSupplier("lookup"))
              .build();
        }
      }
    }
    return getLookupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest,
      pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delete",
      requestType = pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest.class,
      responseType = pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest,
      pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest, pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> getDeleteMethod;
    if ((getDeleteMethod = NamingServerServiceGrpc.getDeleteMethod) == null) {
      synchronized (NamingServerServiceGrpc.class) {
        if ((getDeleteMethod = NamingServerServiceGrpc.getDeleteMethod) == null) {
          NamingServerServiceGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest, pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NamingServerServiceMethodDescriptorSupplier("delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NamingServerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NamingServerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NamingServerServiceStub>() {
        @java.lang.Override
        public NamingServerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NamingServerServiceStub(channel, callOptions);
        }
      };
    return NamingServerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NamingServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NamingServerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NamingServerServiceBlockingStub>() {
        @java.lang.Override
        public NamingServerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NamingServerServiceBlockingStub(channel, callOptions);
        }
      };
    return NamingServerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NamingServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NamingServerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NamingServerServiceFutureStub>() {
        @java.lang.Override
        public NamingServerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NamingServerServiceFutureStub(channel, callOptions);
        }
      };
    return NamingServerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class NamingServerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void lookup(pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupMethod(), responseObserver);
    }

    /**
     */
    public void delete(pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest,
                pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getLookupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest,
                pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse>(
                  this, METHODID_LOOKUP)))
          .addMethod(
            getDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest,
                pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class NamingServerServiceStub extends io.grpc.stub.AbstractAsyncStub<NamingServerServiceStub> {
    private NamingServerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NamingServerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NamingServerServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lookup(pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest request,
        io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NamingServerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<NamingServerServiceBlockingStub> {
    private NamingServerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NamingServerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NamingServerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse register(pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse lookup(pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse delete(pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NamingServerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<NamingServerServiceFutureStub> {
    private NamingServerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NamingServerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NamingServerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> register(
        pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> lookup(
        pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> delete(
        pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_LOOKUP = 1;
  private static final int METHODID_DELETE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NamingServerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NamingServerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse>) responseObserver);
          break;
        case METHODID_LOOKUP:
          serviceImpl.lookup((pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest) request,
              (io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse>) responseObserver);
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

  private static abstract class NamingServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NamingServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pt.ulisboa.tecnico.distledger.contract.namingserver.NamingServerDistLedger.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NamingServerService");
    }
  }

  private static final class NamingServerServiceFileDescriptorSupplier
      extends NamingServerServiceBaseDescriptorSupplier {
    NamingServerServiceFileDescriptorSupplier() {}
  }

  private static final class NamingServerServiceMethodDescriptorSupplier
      extends NamingServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NamingServerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (NamingServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NamingServerServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getLookupMethod())
              .addMethod(getDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
